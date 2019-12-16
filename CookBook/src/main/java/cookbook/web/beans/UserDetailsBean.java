package cookbook.web.beans;

import cookbook.domain.models.service.PostServiceModel;
import cookbook.domain.models.service.UserServiceModel;
import cookbook.service.PostService;
import cookbook.service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.List;

@Named
@RequestScoped
public class UserDetailsBean {

    private UserService userService;
    private PostService postService;

    private List<PostServiceModel> post;

    public UserDetailsBean() {
    }

    @Inject
    public UserDetailsBean(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    public List<PostServiceModel> getPost(String id) {
        return this.postService.getAllUsersPosts(id);
    }

    public void setPost(List<PostServiceModel> post) {
        this.post = post;
    }

    public UserServiceModel getUser(String id) {
        return this.userService.findUserById(id);
    }
}
