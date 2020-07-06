package com.fjnu.kbms.serviceimpl;

import com.fjnu.kbms.bean.Comment;
import com.fjnu.kbms.dao.CommentMapper;
import com.fjnu.kbms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<Comment> getCommentByApId(Integer apid) {
        return commentMapper.selectByApId(apid);
    }

    @Override
    public void addComment(Comment comment) {
        commentMapper.insertSelective(comment);
    }

    @Override
    public List<Comment> selectByForeignKey(Integer commentAp) {
        return commentMapper.selectByForeignKey(commentAp);
    }
}
