package jobs.web.beans;

import jobs.domain.models.binding.UserLoginBindingModel;
import jobs.domain.models.service.UserServiceModel;
import jobs.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class LoginBean extends BaseBean {

    private UserLoginBindingModel userLoginBindingModel;

    private UserService userService;

    public LoginBean() {
    }

    @Inject
    public LoginBean(UserService userService) {
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
