package com.example.demo2.service;

import com.example.demo2.model.Post;
import com.example.demo2.model.Reply;
import com.example.demo2.repository.ReplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    public ReplyServiceImpl(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    @Override
    public void createReply(Reply reply) {
        replyRepository.createReply(reply);
    }

    @Override
    public List<Reply> getRepliesByPost(Post post) {
        return replyRepository.getRepliesByPost(post);
    }
}
