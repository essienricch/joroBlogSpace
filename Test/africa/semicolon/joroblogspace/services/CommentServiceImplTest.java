package africa.semicolon.joroblogspace.services;

import africa.semicolon.joroblogspace.dtos.comment.requests.CreateCommentRequest;
import africa.semicolon.joroblogspace.dtos.post.requests.CreatePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@Service
class CommentServiceImplTest {

    @Autowired
    private  CommentService commentService;
    @Autowired
    private PostService postService;


    @BeforeEach
    void setUp(){
        commentService = new CommentServiceImpl();
        postService = new PostServiceImpl();
    }

    @Test
    void createCommentTest(){
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("New post");
        createPostRequest.setBody("Life is good");
        postService.createPost(createPostRequest);

        CreateCommentRequest createCommentRequest = new CreateCommentRequest();
        createCommentRequest.setCommenterName("Ojo");
        createCommentRequest.setComment("love life");
        createCommentRequest.setPostId("1");
        commentService.createComment(createCommentRequest);

        assertEquals(1, commentService.viewAll().size());
    }

}