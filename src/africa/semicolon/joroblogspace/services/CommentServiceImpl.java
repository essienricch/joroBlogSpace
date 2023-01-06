package africa.semicolon.joroblogspace.services;

import africa.semicolon.joroblogspace.data.models.Comment;
import africa.semicolon.joroblogspace.data.repositories.CommentRepository;
import africa.semicolon.joroblogspace.dtos.comment.requests.CreateCommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostService postService;

    @Override
    public void createComment(CreateCommentRequest createCommentRequest) {
        Comment comment = new Comment();
        comment.setComment(createCommentRequest.getComment());
        comment.setCommenterName(createCommentRequest.getCommenterName());
        Comment savedComment = commentRepository.save(comment);
        postService.addComment(createCommentRequest.getPostId(), savedComment);
    }

    @Override
    public Comment viewComment(String id) {
        return null;
    }

    @Override
    public List<Comment> viewAll() {
        return commentRepository.findAll();
    }
}
