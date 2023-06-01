package com.example.demo2.repository;

import com.example.demo2.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReplyRepository extends JpaRepository<Reply,Long> {

//    public void createReply(Reply reply);

    List<Reply> getRepliesByPostId(Long postId);
}
