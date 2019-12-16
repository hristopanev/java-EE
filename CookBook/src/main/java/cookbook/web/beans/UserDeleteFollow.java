package cookbook.web.beans;

import cookbook.domain.models.service.UserServiceModel;
import cookbook.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class UserDeleteFollow extends BaseBean {
    private UserService userService;

    public UserDeleteFollow() {
    }

    @Inject
    public UserDeleteFollow(UserService userService) {
        this.userService = userService;
    }

    public UserServiceModel getUser(String id) {
        UserServiceModel user = this.userService.findUserById(id);

        return user;
    }

    public void delete(String id) {

        String loggedInUser =(String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("user-id");

        this.userService.deleteFollow(loggedInUser, id);
        this.redirect("/my-follow");
    }
}
