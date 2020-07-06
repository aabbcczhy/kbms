package com.fjnu.kbms.serviceimpl;

import com.fjnu.kbms.bean.Comment;
import com.fjnu.kbms.dao.CommentMapper;
import com.fjnu.kbms.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author aabbcczhy
 */
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
}
