package com.example.demo2.service;

import com.example.demo2.model.Post;
import com.example.demo2.model.Reply;
import com.example.demo2.in_memory_repo.PostRepositoryInMemo;
import com.example.demo2.in_memory_repo.ReplyRepositoryInMemo;
import com.example.demo2.repository.PostRepository;
import com.example.demo2.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    public ReplyServiceImpl(){};
    private ReplyRepository replyRepository;
    private PostRepository postRepository;

    public ReplyServiceImpl(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

//    @Override
//    public void createReply(Reply reply) {
//        reply.setTimestamp(LocalDateTime.now());
//        replyRepository.createReply(reply);
//    }


    @Override
    public Post getPostById(Long postId) {
        return postRepository.getPostById(postId);
    }

    @Override
    public List<Reply> getRepliesByPostId(Long postId) {
        Post post = postRepository.getPostById(postId);
        if (post != null) {
            return replyRepository.getRepliesByPostId(postId);
        } else {
            return Collections.emptyList();
        }
    }

}
