package africa.semicolon.joroblogspace.data.repositories;


import africa.semicolon.joroblogspace.data.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository{

    private int idCounter;

    private List <Comment> comments = new ArrayList<>();

    @Override
    public Comment save(Comment comment) {
        comments.add(comment);
        idCounter++;
        comment.setId(idCounter);
        return comment;
    }

    @Override
    public Comment findById(int id) {
        for (Comment comment : comments){
            if (comment.getId() == id)
                return comment;
        }
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public long count() {
        return comments.size();
    }

    @Override
    public void delete(Comment comment) {

    }

    @Override
    public void delete(int id) {

    }
}
