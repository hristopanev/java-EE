package web.beans;

import domain.models.binding.UserLoginBindingModel;
import domain.models.service.UserServiceModel;
import org.apache.commons.codec.digest.DigestUtils;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class UserLoginBean extends BaseBean {

    private UserLoginBindingModel userLoginBindingModel;

    private UserService userService;

    public UserLoginBean() {
    }

    @Inject
    public UserLoginBean(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        this.userLoginBindingModel = new UserLoginBindingModel();
    }

    public UserLoginBindingModel getUserLoginBindingModel() {
        return this.userLoginBindingModel;
    }

    public void setUserLoginBindingModel(UserLoginBindingModel userLoginBindingModel) {
        this.userLoginBindingModel = userLoginBindingModel;
    }

    public void login() throws IOException {
        UserServiceModel user = this.userService.getUserByUsername(this.userLoginBindingModel.getUsername());

        if (user == null || !user.getPassword()
                .equals(DigestUtils.sha256Hex(this.userLoginBindingModel.getPassword()))){
            return;
        }

        var sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        sessionMap.put("user-id", user.getId());
        sessionMap.put("username", user.getUsername());
        this.redirect("/home");
    }
}
