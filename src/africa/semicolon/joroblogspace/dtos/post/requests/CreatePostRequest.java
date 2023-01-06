package africa.semicolon.joroblogspace.dtos.post.requests;

import lombok.Data;

@Data
public class CreatePostRequest {

    private String title;
    private String body;

}
