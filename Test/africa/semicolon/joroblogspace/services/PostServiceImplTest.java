package africa.semicolon.joroblogspace.services;

import africa.semicolon.joroblogspace.data.models.Comment;
import africa.semicolon.joroblogspace.data.models.Post;
import africa.semicolon.joroblogspace.dtos.post.requests.CreatePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Service

public class PostServiceImplTest {


    @Autowired
    private PostService postService;
    private CreatePostRequest createPostRequest;


    @BeforeEach
    void setUp(){
        postService = new PostServiceImpl();
        createPostRequest = new CreatePostRequest();
    }

    @Test
    void createPostTest(){
        createPostRequest.setTitle("New post");
        createPostRequest.setBody("Life is good");
        postService.createPost(createPostRequest);
        assertEquals(1L, postService.viewAllPost().size());
    }

    @Test
    void viewPostTest(){

        createPostRequest.setTitle("New post");
        createPostRequest.setBody("Life is good");
        postService.createPost(createPostRequest);
        assertEquals(1L, postService.viewAllPost().size());

        Post post = postService.viewPost("1");
        assertEquals("New post", post.getTitle());
        assertEquals("Life is good",post.getBody());
    }

    @Test
    void addCommentTest(){

        //given i have a saved post

        createPostRequest.setTitle("New post");
        createPostRequest.setBody("Life is good");
        postService.createPost(createPostRequest);

        //given i have a comment
        Comment comment = new Comment();
        comment.setComment("i love your post");
        postService.addComment("1",comment);
        //when i save the comment to post
        Post savedPost = postService.viewPost("1");
        //confirm that post's comment is now 1
        assertEquals(1, savedPost.getComments().size());
        List <Comment> comments = savedPost.getComments();
        Comment firstComment = comments.get(0);
        assertEquals("i love your post",savedPost.getComments().get(0).getComment());

    }

}