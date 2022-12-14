package africa.semicolon.joroblogspace.data.repositories;

import africa.semicolon.joroblogspace.data.models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostRepositoryImplTest {

   private PostRepository postRepository;

    @BeforeEach
    void setUp(){
        postRepository = new PostRepositoryImpl();
    }

    @Test
    void saveNewPost_countShouldBeOne_Test(){
        Post post = new Post();
        post.setBody("Our Post Body");
        post.setTitle("Our Post Title");
        postRepository.save(post);

        assertEquals(1L, postRepository.count());
    }

    @Test
    void saveNewPost_FindById_shouldReturnSavedPostTest(){
        Post post = new Post();
        post.setBody("Our Post Body");
        post.setTitle("Our Post Title");
        postRepository.save(post);

        assertEquals(1L, postRepository.count());

        Post savedPost = postRepository.findById(1);
        assertEquals(post,savedPost);

        Post post1 = new Post();
        postRepository.save(post1);
        assertEquals(post1,postRepository.findById(2));
    }

    @Test
    void saveNewPost_updatePost_countIsOneTest(){
        Post post = new Post();
        post.setBody("Our Post Body");
        post.setTitle("Our Post Title");
        postRepository.save(post);

        Post updatedPost = new Post();
        updatedPost.setId(1);
        updatedPost.setBody("Updated body");
        updatedPost.setTitle("updated title");
        postRepository.save(updatedPost);

        assertEquals(1L, postRepository.count());
        assertEquals(post, postRepository.findById(1));
        assertEquals("Updated body", post.getBody());
        assertEquals("updated title", post.getTitle());
    }

    @Test
    void deleteItem_countIsZeroTest(){
        Post post = new Post();
        post.setBody("Our Post Body");
        post.setTitle("Our Post Title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());
        postRepository.delete(1);
        assertEquals(0L, postRepository.count());



    }

}