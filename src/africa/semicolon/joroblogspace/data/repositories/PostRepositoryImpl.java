package africa.semicolon.joroblogspace.data.repositories;

import africa.semicolon.joroblogspace.data.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository{

    private List <Post> postMalone = new ArrayList<>();


    @Override
    public Post save(Post post) {

        if (post.getId() != 0)update(post);
        else {
            post.setId(postMalone.size() + 1);
            postMalone.add(post);
        }
        return post;
    }


    private void update(Post post){
        Post savedPost = findById(post.getId());
        savedPost.setTitle(post.getTitle());
        savedPost.setBody(post.getBody());

    }
    @Override
    public Post findById(int id) {
        for (Post post : postMalone){
            if (post.getId() == id){
                return post;
            }
        }
        return null;
    }

    @Override
    public List<Post> findAll() {
        return postMalone;
    }

    @Override
    public long count() {
        return postMalone.size();
    }

    @Override
    public void delete(Post post) {

    }

    @Override
    public void delete(int id) {
        postMalone.remove(id - 1);

    }
}
