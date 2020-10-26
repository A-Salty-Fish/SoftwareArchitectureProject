package com.example.demo.Imp;

import com.example.demo.entity.Comment;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ICommentService {
    public Comment GetCommentById(int id);
    public Comment AddComment(HttpServletRequest req);
    public Comment DeleteCommentById(int id);
    public Comment UpdateComment(HttpServletRequest req);
    public List<Comment> GetCommentPage(int CurrentPage,
                                        int PageSize);
    public List<Comment> GetCommentByContent(String content);
    public List<Comment> GetAllComment();
}
