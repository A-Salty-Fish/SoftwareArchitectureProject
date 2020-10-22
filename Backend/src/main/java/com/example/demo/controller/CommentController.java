package com.example.demo.controller;

import com.example.demo.Imp.ICommentService;
import com.example.demo.other.SubPage;
import com.example.demo.other.SqlSessionFactoryUtil;
import com.example.demo.entity.Comment;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @GetMapping(value = "/GetCommentById/{id}")
    @ResponseBody
    public Comment GetCommentById(@PathVariable("id") int id) {
        return commentService.GetCommentById(id);
    }

    @PostMapping(value = "/AddComment")
    @ResponseBody
    public Comment AddComment(HttpServletRequest req){
        return commentService.AddComment(req);
    }

    @DeleteMapping(value = "/DeleteCommentById/{id}")
    @ResponseBody
    public Comment DeleteCommentById(@PathVariable("id") int id) {
        return commentService.DeleteCommentById(id);
    }

    @PostMapping(value = "/UpdateComment")
    @ResponseBody
    public Comment UpdateComment(HttpServletRequest req){
        return commentService.UpdateComment(req);
    }

    @GetMapping(value = "/GetCommentPage/{CurrentPage}/{PageSize}")
    @ResponseBody
    public List<Comment> GetCommentPage(@PathVariable("CurrentPage") int CurrentPage,
                                        @PathVariable("PageSize") int PageSize){
        return commentService.GetCommentPage(CurrentPage,PageSize);
    }

    @GetMapping(value = "/GetCommentByContent/{content}")
    @ResponseBody
    public List<Comment> GetCommentByContent(@PathVariable("content") String content){
        return commentService.GetCommentByContent(content);
    }
}
