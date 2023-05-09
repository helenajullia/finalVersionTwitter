package com.example.demo2.controller;

import com.example.demo2.model.Post;
import com.example.demo2.model.Reply;
import com.example.demo2.repository.PostRepository;
import com.example.demo2.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReplyController {

    private final ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @PostMapping("/replies")
    public void createReply(@RequestBody Reply reply) {
        replyService.createReply(reply);
    }


    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts/{postId}/replies")
    public List<Reply> getRepliesByPost(@PathVariable Post postId) {
        return replyService.getRepliesByPost(postId);
    }

}
