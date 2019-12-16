package cookbook.web.beans;

import cookbook.domain.models.service.PostServiceModel;
import cookbook.domain.models.service.UserServiceModel;
import cookbook.service.PostService;
import cookbook.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class PostDeleteBean extends BaseBean {
    private PostService postService;
    private UserService userService;

    public PostDeleteBean() {
    }

    @Inject
    public PostDeleteBean(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    public PostServiceModel getPost(String id) {
        PostServiceModel result = this.postService.getPostById(id);
        return result;
    }

    public void delete() {

        String id = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("id");
        this.postService.delete(id);
        this.redirect("/home");
    }
}
