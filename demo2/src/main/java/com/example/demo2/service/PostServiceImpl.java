

package com.example.demo2.service;

        import com.example.demo2.model.Like;
        import com.example.demo2.model.Post;
        import com.example.demo2.model.User;
        import com.example.demo2.repository.PostRepository;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {


public PostServiceImpl (){};
    private UserFollowerFollowingService userFollowerFollowingService;

    private PostRepository postRepository;
@Override
    public void savePost(Post post) {
        postRepository.save(post);
    }



    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }
//@Override
//    public void createPost(Post post) {
//        postRepository.createPost(post);
//    }



   /* public List<String> getLikesByPostId(String postId) {
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

        List<String> followedUsers = userFollowerFollowingService.getFollowedUsers(username);

        for (String followedUser : followedUsers) {
            List<Post> postsByUser = postRepository.getPostsByUser(followedUser);
            postsByFollowedUser.addAll(postsByUser);
        }

        return postsByFollowedUser;
    }
    public Post getPostById(String postId) {
        return postRepositoryInMemo.getPostById(postId);
    }

    @Override
    public void likePost(String postId, Like like) {
        Post post = postRepositoryInMemo.getPostById(postId);
        if (post != null) {
            List<Like> likes = post.getLikes();
            likes.add(like);
            // Save the updated likes to the post
            post.setLikes(likes);
            postRepositoryInMemo.updatePost(post);
        }
    }*/

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
    public void likePost(Long postId, Like like) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            List<Like> likes = post.getLikes();
            likes.add(like);
            // Save the updated likes to the post
            post.setLikes(likes);
            postRepository.save(post);
        }
    }
}
