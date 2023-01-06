package africa.semicolon.joroblogspace.controllers;

import africa.semicolon.joroblogspace.data.models.Post;
import africa.semicolon.joroblogspace.dtos.post.requests.CreatePostRequest;
import africa.semicolon.joroblogspace.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public String createPost(@RequestBody CreatePostRequest createPostRequest){
        postService.createPost(createPostRequest);
        return "Post Created Successfully";
    }

    @GetMapping("/post/{postId}")
    public Post viewPost(@PathVariable String postId){

        return postService.viewPost(postId);
    }
}
