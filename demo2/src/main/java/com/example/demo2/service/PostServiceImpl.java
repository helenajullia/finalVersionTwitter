

package com.example.demo2.service;

        import com.example.demo2.model.Like;
        import com.example.demo2.model.Post;
        import com.example.demo2.model.User;
        import com.example.demo2.repository.PostRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import com.example.demo2.service.PostService;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private UserService userService;
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(Post post) {
        postRepository.createPost(post);
    }

    public List<String> getLikesByPostId(String postId) {
        Post post = getPostById(postId);
        if (post != null) {
            List<Like> likes = post.getLikes();
            List<String> usernames = new ArrayList<>();
            for (Like like : likes) {
                usernames.add(like.getUsername());
            }
            return usernames;
        } else {
            return Collections.emptyList();
        }
    }

    public List<Post> getPostsByUser(String username) {
        List<Post> postsByUser = new ArrayList<>();

        for (Post post : postRepository.getAllPosts()) {
            if (post.getUsername().equals(username)) {
                post.setUsername(username);

                // Retrieve the likes for the post using postId
                List<String> likes = getLikesByPostId(post.getId());
                List<Like> likeObjects = new ArrayList<>();

                // Create Like objects from the usernames and postId
                for (String likeUsername : likes) {
                    Like like = new Like(likeUsername, post.getId());
                    likeObjects.add(like);
                }

                // Set the likes for the post
                post.setLikes(likeObjects);

                postsByUser.add(post);
            }
        }
        return postsByUser;
    }


    @Override
    public List<Post> getPostsByFollowedUsers(User user) {
        return null;
    }


    public List<Post> getPostsByFollowedUser(String username) {
        List<Post> postsByFollowedUser = new ArrayList<>();

        List<String> followedUsers = userService.getFollowedUsers(username);

        for (String followedUser : followedUsers) {
            List<Post> postsByUser = postRepository.getPostsByUser(followedUser);
            postsByFollowedUser.addAll(postsByUser);
        }

        return postsByFollowedUser;
    }
    public Post getPostById(String postId) {
        return postRepository.getPostById(postId);
    }

    @Override
    public void likePost(String postId, Like like) {
        Post post = postRepository.getPostById(postId);
        if (post != null) {
            List<Like> likes = post.getLikes();
            likes.add(like);
            // Save the updated likes to the post
            post.setLikes(likes);
            postRepository.updatePost(post);
        }
    }
}
