package africa.semicolon.joroblogspace.services;

import africa.semicolon.joroblogspace.data.models.Comment;
import africa.semicolon.joroblogspace.data.models.Post;
import africa.semicolon.joroblogspace.dtos.post.requests.CreatePostRequest;

import java.util.List;

public interface PostService{

    void createPost(CreatePostRequest createPostRequest);
    void updatePost(String  id, String title, String body);
    void deletePost(String  id);
    Post viewPost(String id);

    List <Post> viewAllPost();
    void addComment(String postId, Comment comment);
}
