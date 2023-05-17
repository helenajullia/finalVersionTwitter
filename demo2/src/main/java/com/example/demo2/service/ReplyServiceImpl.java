package com.example.demo2.service;

import com.example.demo2.model.Post;
import com.example.demo2.model.Reply;
import com.example.demo2.repository.PostRepository;
import com.example.demo2.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    public ReplyServiceImpl(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    @Override
    public void createReply(Reply reply) {
        reply.setTimestamp(LocalDateTime.now());
        replyRepository.createReply(reply);
    }


    @Override
    public Post getPostById(String postId) {
        return postRepository.getPostById(postId);
    }

    @Override
    public List<Reply> getRepliesByPostId(String postId) {
        Post post = postRepository.getPostById(postId);
        if (post != null) {
            return replyRepository.getRepliesByPostId(postId);
        } else {
            // Handle the case when the post does not exist
            return Collections.emptyList();
        }
    }

}
