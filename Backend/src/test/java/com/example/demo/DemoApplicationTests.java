package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.memory.CareTaker;
import com.example.demo.memory.Originator;
import com.example.demo.memory.SqlStep;
import com.example.demo.other.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        SqlSession session = SqlSessionFactoryUtil.openSqlSession();
        int lastId = session.selectOne("getLastId");
        System.out.println(lastId);
    }

    @Test
    void testMem(){
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState(new SqlStep("add ",13));
        careTaker.addState(originator.saveStateToMemento());
        originator.setState(new SqlStep("delete ",13));
        careTaker.addState(originator.saveStateToMemento());
        SqlStep current = careTaker.getState().getStep();
        SqlStep last = careTaker.getState().getStep();
        System.out.println(current.getCmd()+current.getId());
        System.out.println(last.getCmd()+last.getId());
    }

}
