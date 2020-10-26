package com.example.demo.Impl;

import com.example.demo.Imp.ICommentService;
import com.example.demo.entity.Comment;
import com.example.demo.other.SqlSessionFactoryUtil;
import com.example.demo.other.SubPage;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements ICommentService {

    static SqlSession session = SqlSessionFactoryUtil.openSqlSession();

    @Override
    public Comment GetCommentById(int id) {
        Comment comment = session.selectOne("getComment",id);
        return comment;
    }

    @Override
    public Comment AddComment(HttpServletRequest req) {
        Comment comment = Comment.ReqToComment(req);
        session.insert("addComment",comment);
        session.commit();
        return comment;
    }

    @Override
    public Comment DeleteCommentById(int id) {
        Comment comment = session.selectOne("getComment",id);
        if (comment != null){
            session.delete("deleteComment",id);
            session.commit();
        }
        return comment;
    }

    @Override
    public Comment UpdateComment(HttpServletRequest req) {
        Comment comment = Comment.ReqToComment(req);
        session.update("updateComment",comment);
        session.commit();
        return comment;
    }

    @Override
    public List<Comment> GetCommentPage(int CurrentPage, int PageSize) {
        List<Comment> commentList = session.selectList("getCommentPage",
                SubPage.SubPageMap(CurrentPage,PageSize));
        return commentList;
    }

    @Override
    public List<Comment> GetCommentByContent(String content) {
        List<Comment> commentList = session.selectList("getCommentByLikeContent","%"+content+"%");
        return commentList;
    }

    @Override
    public List<Comment> GetAllComment() {
        List<Comment> commentList = session.selectList("listComment");
        return commentList;
    }
}
