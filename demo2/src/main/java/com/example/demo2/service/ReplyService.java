package com.example.demo2.service;

import com.example.demo2.model.Post;
import com.example.demo2.model.Reply;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReplyService {
    void createReply(Reply reply);
    List<Reply> getRepliesByPostId(Long postId);
    Post getPostById(Long postId);
}
