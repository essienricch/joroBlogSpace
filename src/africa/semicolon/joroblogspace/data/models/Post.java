package africa.semicolon.joroblogspace.data.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private String title;
    private LocalDateTime creationTime = LocalDateTime.now();
    private int Id;
    private String body;

    private List <Comment> comments = new ArrayList<>();


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", creationTime=" + creationTime +
                ", Id=" + Id +
                ", body='" + body + '\'' +
                ", comments=" + comments +
                '}';
    }
}
