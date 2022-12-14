package africa.semicolon.joroblogspace.data.repositories;

import africa.semicolon.joroblogspace.data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryImplTest {

    private CommentRepository commentRepository;

    @BeforeEach
    void setUp(){
        commentRepository = new CommentRepositoryImpl();
    }

    @Test
    void saveComment_countShouldBeOneTest(){
        Comment comment = new Comment();
        comment.setCommenterName("doro");
        comment.setComment("Smd");
        commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());
    }

    @Test
    void saveNewComment_findById_shouldReturnSavedComments(){
        Comment comment = new Comment();
        comment.setCommenterName("doro");
        comment.setComment("Smd");
        commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());

        Comment savedComment = commentRepository.findById(1);
        assertEquals(comment,savedComment);
    }

    @Test
    void saveNewComment_updateComment_countIsOneTest(){
        Comment comment = new Comment();
        comment.setCommenterName("doro");
        comment.setComment("Smd");
        commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());

        Comment comment1 = new Comment();
    }

}