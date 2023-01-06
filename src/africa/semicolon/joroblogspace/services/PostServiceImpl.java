package africa.semicolon.joroblogspace.services;

import africa.semicolon.joroblogspace.data.models.Comment;
import africa.semicolon.joroblogspace.data.models.Post;
import africa.semicolon.joroblogspace.data.repositories.PostRepository;
import africa.semicolon.joroblogspace.dtos.post.requests.CreatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;



    @Override
    public void createPost(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setTitle(createPostRequest.getTitle());
        post.setBody(createPostRequest.getBody());
        postRepository.save(post);
    }

    @Override
    public void updatePost(String id, String title, String body) {

    }

    @Override
    public void deletePost(String id) {

    }


    @Override
    public Post viewPost(String id) {
       return postRepository.findPostById(id);
    }

    @Override
    public List<Post> viewAllPost() {
        return postRepository.findAll();
    }

    @Override
    public void addComment(String postId, Comment comment) {
        Post savedPost = viewPost(postId);
        savedPost.getComments().add(comment);
        postRepository.save(savedPost);

    }
}
