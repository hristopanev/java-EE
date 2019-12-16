package cookbook.web.beans;

import cookbook.domain.models.service.UserServiceModel;
import cookbook.service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class UserListBean {
    private List<UserServiceModel> userServiceModel;

    private UserService userService;

    public UserListBean() {
    }

    @Inject
    public UserListBean(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        this.setUserServiceModel(this.userService.findAllUsers());
    }

    public List<UserServiceModel> getUserServiceModel() {
        return this.userServiceModel;
    }

    public void setUserServiceModel(List<UserServiceModel> userServiceModel) {
        this.userServiceModel = userServiceModel;
    }

    public UserServiceModel getUser(String id) {
        return this.userService.findUserById(id);
    }

}
