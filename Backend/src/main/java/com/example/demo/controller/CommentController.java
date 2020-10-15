package com.example.demo.controller;

import com.example.demo.Imp.SubPage;
import com.example.demo.config.SqlSessionFactoryUtil;
import com.example.demo.entity.Canteen;
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
import java.util.List;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    static SqlSession session = SqlSessionFactoryUtil.openSqlSession();

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

    @PostMapping(value = "/UpdateComment")
    @ResponseBody
    public Comment UpdateComment(HttpServletRequest req){
        Comment comment = Comment.ReqToComment(req);
        session.update("updateComment",comment);
        session.commit();
        return comment;
    }

    @GetMapping(value = "/GetCommentPage/{CurrentPage}/{PageSize}")
    @ResponseBody
    public List<Comment> GetCommentPage(@PathVariable("CurrentPage") int CurrentPage,
                                        @PathVariable("PageSize") int PageSize){
        List<Comment> commentList = session.selectList("listComment");
        return SubPage.GetSubPage(commentList,CurrentPage,PageSize);
    }
}
