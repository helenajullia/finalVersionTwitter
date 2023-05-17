package com.example.demo2.controller;

import com.example.demo2.model.Post;
import com.example.demo2.model.Reply;
import com.example.demo2.repository.PostRepository;
import com.example.demo2.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private PostRepository postRepository;

    public ReplyController(ReplyService replyService, PostRepository postRepository) {
        this.replyService = replyService;
        this.postRepository = postRepository;
    }

    @PostMapping("/replies")
    public ResponseEntity<?> createReply(@RequestBody Reply reply) {
        try {
            replyService.createReply(reply);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
    @GetMapping("/posts/{postId}/replies")
    public List<Reply> getRepliesByPost(@PathVariable String postId) {
        return replyService.getRepliesByPostId(postId);
    }
}
