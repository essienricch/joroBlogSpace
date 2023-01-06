package africa.semicolon.joroblogspace.dtos.comment.requests;

import lombok.*;

@Data
public class CreateCommentRequest {

    private String postId;
    private String commenterName;
    private String comment;

}
