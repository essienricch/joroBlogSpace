package africa.semicolon.joroblogspace.data.repositories;

import africa.semicolon.joroblogspace.data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


class CommentRepositoryImplTest {

    @Autowired
    private CommentRepository commentRepository;


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
        comment.setId("1");
        commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());

        Comment savedComment = commentRepository.findPostById("1");
        assertEquals(comment,savedComment);

//        Comment comment1 = new Comment();
//        commentRepository.save(comment1);
//        assertEquals(2,commentRepository.count());
//        assertEquals(comment1, commentRepository.findById("1"));
    }

    @Test
    void saveNewComment_updateComment_countIsOneTest(){
        Comment comment = new Comment();
        comment.setCommenterName("doro");
        comment.setComment("Smd");
        commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());

        Comment updatedComment = new Comment();
        updatedComment.setId("1");
        updatedComment.setCommenterName("joro");
        updatedComment.setComment("just give me good life");
        commentRepository.save(updatedComment);
        assertEquals(1,commentRepository.count());
        assertEquals(comment,commentRepository.findById("1"));
        assertEquals("joro",comment.getCommenterName());
        assertEquals("just give me good life", comment.getComment());
    }

    @Test
    void saveNew_deleteCommentById_countIsZeroTest(){
        Comment comment = new Comment();
        comment.setCommenterName("doro");
        comment.setComment("Smd");
        commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());

        commentRepository.delete(comment);
        assertEquals(0L, commentRepository.count());
       //
       // assertNotEquals("doro", comment.getCommenterName());
    }

    @Test
    void saveNewComment_deleteComment_shouldNotFindTheCommentDeleted(){
        Comment comment = new Comment();
        comment.setCommenterName("doro");
        comment.setComment("Smd");
        commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());

        commentRepository.delete(comment);
        assertEquals(0, commentRepository.count());
    }

}