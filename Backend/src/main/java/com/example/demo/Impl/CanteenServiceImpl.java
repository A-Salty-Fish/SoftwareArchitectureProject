package com.example.demo.Impl;

import com.example.demo.Imp.ICanteenService;
import com.example.demo.entity.Canteen;
import com.example.demo.other.SqlSessionFactoryUtil;
import com.example.demo.other.SubPage;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("canteenService")
public class CanteenServiceImpl implements ICanteenService {

    static SqlSession session = SqlSessionFactoryUtil.openSqlSession();

    @Override
    public Canteen GetCanteenById(int id) {
        Canteen canteen = session.selectOne("getCanteenById", id);
        return canteen;
    }

    @Override
    public Canteen DeleteCanteenById(int id) {
        Canteen canteen = session.selectOne("getCanteenById", id);
        if (canteen != null)
        {
            session.delete("deleteCanteenById",id);
            session.commit();
        }
        return canteen;
    }

    @Override
    public Canteen AddCanteen(HttpServletRequest req) {
        Canteen canteen = Canteen.ReqToCanteen(req);
        session.insert("addCanteen",canteen);
        session.commit();
        return canteen;
    }

    @Override
    public Canteen UpdateCanteen(HttpServletRequest req) {
        Canteen canteen = Canteen.ReqToCanteen(req);
        session.update("updateCanteen",canteen);
        session.commit();
        return canteen;
    }

    @Override
    public List<Canteen> GetCanteenPage(int CurrentPage, int PageSize) {
        List<Canteen> canteenList = session.selectList("getCanteenPage",
                SubPage.SubPageMap(CurrentPage,PageSize));
        return canteenList;
    }

    @Override
    public List<Canteen> GetCanteenByName(String name) {
        List<Canteen> canteenList = session.selectList("getCanteenByLikeName","%"+name+"%");
        return canteenList;
    }

    @Override
    public List<Canteen> GetAllCanteen() {
        List<Canteen> canteenList = session.selectList("listCanteen");
        return canteenList;
    }
}
