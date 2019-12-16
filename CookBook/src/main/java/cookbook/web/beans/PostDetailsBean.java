package cookbook.web.beans;

import cookbook.domain.models.service.PostServiceModel;
import cookbook.service.PostService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PostDetailsBean extends BaseBean {
    private PostService postService;

    public PostDetailsBean() {
    }

    @Inject
    public PostDetailsBean(PostService postService) {
        this.postService = postService;
    }

    public PostServiceModel getPost(String id) {
        return this.postService.getPostById(id);
    }
}
