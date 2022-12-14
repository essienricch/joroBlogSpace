package africa.semicolon.joroblogspace.controllers;

import africa.semicolon.joroblogspace.data.models.Post;
import africa.semicolon.joroblogspace.dtos.requests.CreatePostRequest;
import africa.semicolon.joroblogspace.services.PostService;
import africa.semicolon.joroblogspace.services.PostServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private PostService postService = new PostServiceImpl();

    @PostMapping("/post")
    public String createPost(@RequestBody CreatePostRequest createPostRequest){
        postService.createPost(createPostRequest);
        return "Successful";
    }

    @GetMapping("/post/{postId}")
    public Post viewPost(@PathVariable int postId){
        return postService.viewPost(postId);
    }
}
