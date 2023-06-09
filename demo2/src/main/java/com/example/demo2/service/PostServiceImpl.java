

package com.example.demo2.service;

        import com.example.demo2.model.Post;
        import com.example.demo2.model.User;
        import com.example.demo2.repository.PostRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import com.example.demo2.service.PostService;

        import java.util.ArrayList;
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

    public List<Post> getPostsByUser(User user) {
        List<Post> postsByUser = new ArrayList<>();

        for (Post post : postRepository.getAllPosts()) {
            if (post.getUser().getUsername().equals(user.getUsername())) {
                postsByUser.add(post);
            }
        }

        return postsByUser;
    }

    @Override
    public List<Post> getPostsByFollowedUsers(User user) {
        return null;
    }


    public List<Post> getPostsByFollowedUser(User user) {
        List<Post> postsByFollowedUser = new ArrayList<>();

        List<User> followedUsers = userService.getFollowedUsers(user.getUsername());

        for (User followedUser : followedUsers) {
            List<Post> postsByUser = postRepository.getPostsByUser(followedUser);
            postsByFollowedUser.addAll(postsByUser);
        }

        return postsByFollowedUser;
    }
    public Post getPostById(String postId) {
        return postRepository.getPostById(postId);
    }

    @Override
    public void likePost(String postId, String username) {
        Post post = postRepository.getPostById(postId);
        if (post != null) {
            List<String> likes = post.getLikes();
            likes.add(username);
            // Save the updated likes to the post
            post.setLikes(likes);
            postRepository.updatePost(post);
        }
    }
}
