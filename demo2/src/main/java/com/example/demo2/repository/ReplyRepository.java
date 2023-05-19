package com.example.demo2.repository;

import com.example.demo2.model.Post;
import com.example.demo2.model.Reply;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReplyRepository {
    private List<Reply> replies;
    private PostRepository postRepository;

    public ReplyRepository(PostRepository postRepository) {
        this.replies = new ArrayList<>();
        this.postRepository = postRepository;
    }

    public void createReply(Reply reply) {
        replies.add(reply);
    }

    public List<Reply> getRepliesByPostId(String postId) {
        List<Reply> postReplies = new ArrayList<>();
        for (Reply reply : replies) {
            if (reply.getPostId().equals(postId)) {
                Post post = getPostById(reply.getPostId());
                reply.setPost(post);
                postReplies.add(reply);
            }
        }
        return postReplies;
    }

    public Post getPostById(String postId) {
        return postRepository.getPostById(postId);
    }
}
