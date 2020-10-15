package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Food;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    /**
     * 静态Mybatis成员
     */
    static String resource = "mybatis-config.xml";
    static InputStream inputStream;
    static {
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    static SqlSession session = sqlSessionFactory.openSession();

    @GetMapping(value = "/GetCommentById/{id}")
    @ResponseBody
    public Comment GetCommentById(@PathVariable("id") int id) {
        Comment comment = session.selectOne("getComment",id);
        return comment;
    }

    @PostMapping(value = "/AddComment")
    @ResponseBody
    public Comment AddComment(HttpServletRequest req){
        Comment comment = Comment.ReqToComment(req);
        session.insert("addComment",comment);
        session.commit();
        return comment;
    }

    @DeleteMapping(value = "/DeleteCommentById/{id}")
    @ResponseBody
    public Comment DeleteCommentById(@PathVariable("id") int id) {
        Comment comment = session.selectOne("getComment",id);
        if (comment != null){
            session.delete("deleteComment",id);
            session.commit();
        }
        return comment;
    }
}
