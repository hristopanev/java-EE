package jobs.web.beans;

import jobs.domain.models.binding.UserRegisterBindingModel;
import jobs.domain.models.service.UserServiceModel;
import jobs.service.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterBean extends BaseBean {

    private UserRegisterBindingModel userRegisterBindingModel;
    private ModelMapper modelMapper;
    private UserService userService;

    public RegisterBean() {
    }

    @Inject
    public RegisterBean(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @PostConstruct
    public void  init() {
        this.userRegisterBindingModel = new UserRegisterBindingModel();
    }

    public UserRegisterBindingModel getUserRegisterBindingModel() {
        return this.userRegisterBindingModel;
    }

    public void setUserRegisterBindingModel(UserRegisterBindingModel userRegisterBindingModel) {
        this.userRegisterBindingModel = userRegisterBindingModel;
    }

    public void register() {
        if (!this.userRegisterBindingModel.getPassword()
                .equals(this.userRegisterBindingModel.getConfirmPassword())){
            return;
        }
        this.userService.createUser(
                this.modelMapper.map(this.userRegisterBindingModel, UserServiceModel.class));
        this.redirect("/login");
    }
}
