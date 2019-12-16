package cookbook.web.beans;

import cookbook.domain.models.binding.UserRegisterBindingModel;
import cookbook.domain.models.service.UserServiceModel;
import cookbook.service.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UserRegisterBean extends BaseBean {

    private UserRegisterBindingModel userRegisterBindingModel;

    private UserService userService;
    private ModelMapper modelMapper;

    public UserRegisterBean() {
    }

    @Inject
    public UserRegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.userRegisterBindingModel = new UserRegisterBindingModel();
    }

    public UserRegisterBindingModel getUserRegisterBindingModel() {
        return this.userRegisterBindingModel;
    }

    public void setUserRegisterBindingModel(UserRegisterBindingModel userRegisterBindingModel) {
        this.userRegisterBindingModel = userRegisterBindingModel;
    }

    public void register() {

        if (!this.userRegisterBindingModel.getPassword().equals(this.userRegisterBindingModel.getConfirmPassword())) {
            throw new IllegalArgumentException("Password does not match");
        }

        this.userService.userRegister(
                this.modelMapper.map(this.userRegisterBindingModel, UserServiceModel.class));

        this.redirect("/login");
    }
}
