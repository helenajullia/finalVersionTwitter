package com.example.demo2.repository;

import com.example.demo2.model.Post;
import com.example.demo2.model.Reply;
import com.example.demo2.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface ReplyRepository extends JpaRepository<Reply,Long> {

    Reply save(Reply reply);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO replay (ispublic, id, id_post, timestamp,content,username) " +
            "VALUES (?1, ?2, ?3, ?4,?5,?6)", nativeQuery = true)
    void createReply(
            Boolean ispublic,
            Long id,
            Long id_post,
            LocalDateTime timestamp,
            String content,
            User username
    );

    List<Reply> getRepliesByPostId(Long postId);
}
