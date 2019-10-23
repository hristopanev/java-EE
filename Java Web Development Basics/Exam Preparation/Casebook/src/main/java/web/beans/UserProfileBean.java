package web.beans;

import domain.models.service.UserServiceModel;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UserProfileBean {

    private UserServiceModel userServiceModel;
    private UserService userService;

    public UserProfileBean() {
    }

    @Inject
    public UserProfileBean(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        String id = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap().get("id");

        UserServiceModel user = this.userService.findUserById(id);

        user.setGender(getUserServiceModel().getGender().toLowerCase());
    }

    public UserServiceModel getUserServiceModel() {
        return this.userServiceModel;
    }

    public void setUserServiceModel(UserServiceModel userServiceModel) {
        this.userServiceModel = userServiceModel;
    }
}
