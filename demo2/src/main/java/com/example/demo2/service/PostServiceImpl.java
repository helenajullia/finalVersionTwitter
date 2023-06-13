

package com.example.demo2.service;

        import com.example.demo2.model.Like;
        import com.example.demo2.model.Post;
        import com.example.demo2.model.User;
        import com.example.demo2.repository.PostRepository;
        import com.example.demo2.repository.UserRepository;
        import jakarta.transaction.Transactional;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    public PostServiceImpl (){};
    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @Autowired
    private UserFollowerFollowingService userFollowerFollowingService;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }


    @Transactional
    public void createPost(Post post) {
        User user = post.getUsername(); // Fetch the User object from the post parameter
        postRepository.save(post);
    }


    public List<String> getLikesByPostId(Long postId) {
        return postRepository.getLikesByPostId(postId);
    }
    @Override
    public List<Post> getPostsByUser(User username) {
        return postRepository.findPostByUsername(username);
    }
    @Override
    public List<Post> getPostsByFollowedUser(String username) {
        List<Post> postsByFollowedUsers = new ArrayList<>();
        List<User> followedUsers = userFollowerFollowingService.getFollowedUsers(username);


    postsByFollowedUsers =  postRepository.findByUsernameIn(followedUsers);

        return postsByFollowedUsers;
    }
    @Override
    public Post getPostById(Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        return optionalPost.orElse(null);
    }

    @Override
    public void likePost(Long postId, Like like, String username) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            List<Like> likes = post.getLikes();
            likes.add(like);
            like.setPost(post);
            like.setUser(userRepository.getUserByUsername(username));
            post.setLikes(likes);
            postRepository.save(post);
        }
    }
}
