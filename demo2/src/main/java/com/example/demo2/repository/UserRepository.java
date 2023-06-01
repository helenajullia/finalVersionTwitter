package com.example.demo2.repository;

import com.example.demo2.model.User;
import com.example.demo2.model.UserFollowerFollowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
//    User save(User user);
//
//    List<User> findAll();
     User findByUsername(String username);

    User getUserByUsername(String username);

    @Modifying
    @Query("UPDATE User u SET u.username = :#{#user.username}, u.firstName = :#{#user.firstName}, u.lastName = :#{#user.lastName}, u.email = :#{#user.email}, u.password = :#{#user.password} WHERE u.username = :username")
    void updateUser(@Param("username") String username, @Param("user") User user);

    @Modifying
    @Query("DELETE FROM User u WHERE u.username = :username")
    void deleteUser(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE lower(u.username) = lower(:searchTerm) " +
            "OR lower(u.firstName) = lower(:searchTerm) " +
            "OR lower(u.lastName) = lower(:searchTerm)")
    List<User> searchUsers(@Param("searchTerm") String searchTerm);

}
