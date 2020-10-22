package com.example.demo.Impl;

import com.example.demo.Imp.IUserService;
import com.example.demo.entity.User;
import com.example.demo.memory.CareTaker;
import com.example.demo.memory.Originator;
import com.example.demo.memory.SqlStep;
import com.example.demo.other.SqlSessionFactoryUtil;
import com.example.demo.other.SubPage;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    //Bean
    ApplicationContext context =
            new ClassPathXmlApplicationContext("ApplicationContext.xml");
    //单例数据库连接
    static SqlSession session = SqlSessionFactoryUtil.openSqlSession();
    //备忘录模式
    static Originator originator = new Originator();
    static CareTaker<User> careTaker = new CareTaker<User>();
    SqlStep defaultSqlStep = (SqlStep)context.getBean("DefaultSqlStep");//默认状态

    @Override
    public User GetUserById(int id) {
        User user = session.selectOne("getUser",id);
        return user;
    }

    @Override
    public User DeleteUserById(int id) {
        User user = session.selectOne("getUser",id);
        if (user != null)
        {
            //将删除操作保存进备忘录
            originator.setState(new SqlStep("delete",id));
            careTaker.addState(originator.saveStateToMemento());
            careTaker.addData(user);
            //数据库删除操作
            session.delete("deleteUser",id);
            session.commit();
            return user;
        }
        return null;
    }

    @Override
    public String RedoUser() {
        //返回备忘录当前状态
        SqlStep lastStpe = careTaker.getState().getStep();
        switch (lastStpe.getCmd())//根据上一步操作撤销
        {
            case "add":
                session.delete("deleteUser",lastStpe.getId());
                session.commit();
                return "delete " + lastStpe.getId();
            case "delete":
                User user = careTaker.getData();
                session.insert("addUser",user);
                session.commit();
                return "add " + user.getName();
            default:
                if (lastStpe.getCmd().equals(defaultSqlStep.getCmd()))//默认状态 啥都不做
                    return "nothing to redo";
                return "error";
        }
    }

    @Override
    public User AddUser(HttpServletRequest req) {
        //根据post请求体创建成员
        User user = User.ReqToUser(req);
        //数据库添加操作
        session.insert("addUser",user);
        session.commit();
        //搜索最近新添加的成员id
        int id = session.selectOne("getLastId");
        //将添加操作添加进备忘录
        originator.setState(new SqlStep("add",id));
        careTaker.addState(originator.saveStateToMemento());
        return user;
    }

    @Override
    public User UpdateUser(HttpServletRequest req) {
        User user = User.ReqToUser(req);
        session.update("updateUser",user);
        session.commit();
        return user;
    }

    @Override
    public List<User> GetUserPage(int CurrentPage, int PageSize) {
        List<User> userList = session.selectList("getUserPage",
                SubPage.SubPageMap(CurrentPage,PageSize));
        return userList;
    }
}
