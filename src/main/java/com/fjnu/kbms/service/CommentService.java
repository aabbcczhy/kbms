package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommentService {
    List<Comment> selectByForeignKey(Integer commentAp);
}
