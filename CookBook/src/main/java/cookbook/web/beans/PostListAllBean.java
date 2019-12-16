package cookbook.web.beans;

import cookbook.domain.models.service.PostServiceModel;
import cookbook.domain.models.service.UserServiceModel;
import cookbook.service.PostService;
import cookbook.service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PostListAllBean {
    private UserService userService;
    private PostService postService;

    private List<PostServiceModel> post;

    public PostListAllBean() {
    }

    @Inject
    public PostListAllBean(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @PostConstruct
    public void init() {
        this.setPost(this.postService.findAllPost());
    }

    public List<PostServiceModel> getPost() {
        return this.post;
    }

    public void setPost(List<PostServiceModel> post) {
        this.post = post;
    }

    public UserServiceModel getUser(String id) {
        return this.userService.findUserById(id);
    }
}
