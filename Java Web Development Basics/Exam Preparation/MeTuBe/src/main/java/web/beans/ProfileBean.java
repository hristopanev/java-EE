package web.beans;

import domain.models.service.TubeServiceModel;
import domain.models.service.UserServiceModel;
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
public class ProfileBean {

    private UserServiceModel userServiceModel;

    private UserService userService;


    public ProfileBean() {
    }

    @Inject
    public ProfileBean(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        String username = (String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("username");

    }

    public UserServiceModel getUserServiceModel() {
        return this.userServiceModel;
    }

    public void setUserServiceModel(UserServiceModel userServiceModel) {
        this.userServiceModel = userServiceModel;
    }

}
