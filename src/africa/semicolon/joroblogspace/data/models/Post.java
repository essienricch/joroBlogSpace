package africa.semicolon.joroblogspace.data.models;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Data
@Document

public class Post {

    @Id
    @Getter
    private String Id;

    private String title;
    private String body;

    private LocalDateTime creationTime = LocalDateTime.now();
    @DBRef
    private List <Comment> comments = new ArrayList<>();

    public String toString(){
        String time = DateTimeFormatter.ofPattern("EEE, MM/dd/yyyy, hr:mm:ss").format(creationTime);
        return String.format("""
                ===========================
                Post-ID %s
                Posted on %s
                Title: %s
                Body: %s
                ============================
                """,getId(),time,getTitle(),getBody());
    }


}
