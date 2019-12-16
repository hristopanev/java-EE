package cookbook.repository;

import cookbook.domain.entities.Post;
import cookbook.domain.entities.User;

import java.util.List;

public interface PostRepository extends GenericRepository<Post, String > {



    Post editPost(Post post);

    List<Post> findAllPosts(Post post);

    List<Post> findAllUserPostsById(String id);

}
