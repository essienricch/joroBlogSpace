package africa.semicolon.joroblogspace.controllers;

import africa.semicolon.joroblogspace.dtos.comment.requests.CreateCommentRequest;
import africa.semicolon.joroblogspace.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comment")
    public String addComment(@RequestBody CreateCommentRequest createCommentRequest){
        commentService.createComment(createCommentRequest);
        return "Comment Added Successfully";
    }

}
