package web.beans;

import domain.models.service.UserServiceModel;
import org.modelmapper.ModelMapper;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.List;

@Named
@RequestScoped
public class UserHomeBean extends BaseBean {

    private List<UserServiceModel> userServiceModel;

    private UserService userService;

    public UserHomeBean() {
    }

    @Inject
    public UserHomeBean(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        this.setUserServiceModel(this.userService.findAllUsers());
        this.getUserServiceModel().forEach(u -> u.setGender(u.getGender().toLowerCase()));
    }

    public List<UserServiceModel> getUserServiceModel() {
        return this.userServiceModel;
    }

    public void setUserServiceModel(List<UserServiceModel> userServiceModel) {
        this.userServiceModel = userServiceModel;
    }


    public void addFriend(String id) {
        String loggedInUserId =(String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("user-id");

        UserServiceModel loggedInUser = this.userService.findUserById(loggedInUserId);

        UserServiceModel userServiceModel = this.userService.findUserById(id);

        loggedInUser.getFriends().add(userServiceModel);
        userServiceModel.getFriends().add(loggedInUser);

        if (!this.userService.addFriend(loggedInUser)) {
            throw new IllegalArgumentException("Something went wrong!");
        }

        if (!this.userService.addFriend(userServiceModel)) {
            throw new IllegalArgumentException("Something went wrong!");
        }
        this.redirect("home.jsf");
    }
}
