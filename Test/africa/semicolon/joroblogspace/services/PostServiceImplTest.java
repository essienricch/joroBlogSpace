package africa.semicolon.joroblogspace.services;

import africa.semicolon.joroblogspace.data.models.Post;
import africa.semicolon.joroblogspace.dtos.requests.CreatePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostServiceImplTest {

    private PostService postService;


    @BeforeEach
    void setUp(){
        postService = new PostServiceImpl();
    }

    @Test
    void createPostTest(){
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("New post");
        createPostRequest.setBody("Life is good");
        postService.createPost(createPostRequest);
        assertEquals(1L, postService.viewAllPost().size());
    }

    @Test
    void viewPostTest(){
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("New post");
        createPostRequest.setBody("Life is good");
        postService.createPost(createPostRequest);
        assertEquals(1L, postService.viewAllPost().size());

        Post post = postService.viewPost(1);
        assertEquals("New post", post.getTitle());
        assertEquals("Life is good",post.getBody());
    }

}