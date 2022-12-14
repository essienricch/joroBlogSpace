package africa.semicolon.joroblogspace.services;

import africa.semicolon.joroblogspace.data.models.Post;
import africa.semicolon.joroblogspace.dtos.requests.CreatePostRequest;

import java.util.List;

public interface PostService{

    void createPost(CreatePostRequest createPostRequest);
    void updatePost(int id, String title, String body);
    void deletePost(int id);
    Post viewPost(int id);

    List <Post> viewAllPost();
}
