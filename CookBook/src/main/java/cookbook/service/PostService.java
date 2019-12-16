package cookbook.service;

import cookbook.domain.entities.Post;
import cookbook.domain.models.service.PostServiceModel;

import java.util.List;

public interface PostService {

    void postCreate(PostServiceModel postServiceModel);

    List<PostServiceModel> findAllPost(Post post);

    List<PostServiceModel> findAllPost();

    void postEdit(String id);

    PostServiceModel getPostById(String id);

    void delete(String id);

    List<PostServiceModel> getAllUsersPosts(String id);
}
