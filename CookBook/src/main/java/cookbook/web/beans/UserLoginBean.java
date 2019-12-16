package cookbook.web.beans;

import cookbook.domain.models.binding.UserLoginBindingModel;
import cookbook.domain.models.service.UserServiceModel;
import cookbook.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UserLoginBean extends BaseBean {

    private UserLoginBindingModel userLoginBindingModel;

    private UserService userService;
    private ModelMapper modelMapper;

    public UserLoginBean() {
    }

    @Inject
    public UserLoginBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
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

    public void login() {
        UserServiceModel user = this.userService
                .userLogin(this.modelMapper.map(this.userLoginBindingModel, UserServiceModel.class));

        if (user == null
                || !user.getPassword().equals(DigestUtils.sha256Hex(this.userLoginBindingModel.getPassword()))) {
            this.redirect("/login");
        }

        var sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        assert user != null;
        sessionMap.put("user-id", user.getId());
        sessionMap.put("username", user.getUsername());
        sessionMap.put("role", user.getRole());
        this.redirect("/home");
    }
}
