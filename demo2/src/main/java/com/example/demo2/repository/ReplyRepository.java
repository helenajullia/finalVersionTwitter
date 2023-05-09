package com.example.demo2.repository;

import com.example.demo2.model.Post;
import com.example.demo2.model.Reply;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ReplyRepository {
    private List<Reply> replies;

    public ReplyRepository() {
        this.replies = new ArrayList<>();
    }

    public void createReply(Reply reply) {
        replies.add(reply);
    }

    public List<Reply> getRepliesByPost(Post post) {
        List<Reply> postReplies = new ArrayList<>();
        for (Reply reply : replies) {
            if (reply.getPost().equals(post)) {
                postReplies.add(reply);
            }
        }
        return postReplies;
    }
}
