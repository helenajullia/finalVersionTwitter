package com.example.demo2.in_memory_repo;

import com.example.demo2.model.Post;
import com.example.demo2.model.Reply;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReplyRepositoryInMemo {
    /*private List<Reply> replies;
    private PostRepositoryInMemo postRepositoryInMemo;

    public ReplyRepositoryInMemo(PostRepositoryInMemo postRepositoryInMemo) {
        this.replies = new ArrayList<>();
        this.postRepositoryInMemo = postRepositoryInMemo;
    }

    public void createReply(Reply reply) {
        replies.add(reply);
    }

    public List<Reply> getRepliesByPostId(Long postId) {
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
        return postRepositoryInMemo.getPostById(postId);
    }*/
}
