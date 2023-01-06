package africa.semicolon.joroblogspace.services;

import africa.semicolon.joroblogspace.data.models.Comment;
import africa.semicolon.joroblogspace.dtos.comment.requests.CreateCommentRequest;

import java.util.List;

public interface CommentService {

    void createComment(CreateCommentRequest createCommentRequest);

    Comment viewComment(String id);
    List <Comment> viewAll();
}
