package africa.semicolon.joroblogspace.data.repositories;

import africa.semicolon.joroblogspace.data.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    Comment findPostById(String id);
}
