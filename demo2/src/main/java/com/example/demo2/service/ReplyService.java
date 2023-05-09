package com.example.demo2.service;

import com.example.demo2.model.Post;
import com.example.demo2.model.Reply;

import java.util.List;

public interface ReplyService {
    void createReply(Reply reply);
    List<Reply> getRepliesByPost(Post post);
}
