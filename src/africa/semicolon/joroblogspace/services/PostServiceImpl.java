package africa.semicolon.joroblogspace.services;

import africa.semicolon.joroblogspace.data.models.Post;
import africa.semicolon.joroblogspace.data.repositories.PostRepository;
import africa.semicolon.joroblogspace.data.repositories.PostRepositoryImpl;
import africa.semicolon.joroblogspace.dtos.requests.CreatePostRequest;

import java.util.List;

public class PostServiceImpl implements PostService{

   private PostRepository postRepository = new PostRepositoryImpl();

    @Override
    public void createPost(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setTitle(createPostRequest.getTitle());
        post.setBody(createPostRequest.getBody());
        postRepository.save(post);
    }

    @Override
    public void updatePost(int id, String title, String body) {

    }

    @Override
    public void deletePost(int id) {

    }

    @Override
    public Post viewPost(int id) {
//        for (Post post : viewAllPost()){
//            if (post.getId() == id)return post;
//        }
        return postRepository.findById(id);
    }

    @Override
    public List<Post> viewAllPost() {
        return postRepository.findAll();
    }
}
