package web.beans;

import domain.models.service.UserServiceModel;
import org.modelmapper.ModelMapper;
import org.primefaces.component.autocomplete.AutoCompleteHandler;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class UserFriendsBean extends BaseBean {

    private List<UserServiceModel> userServiceModel;

    private UserService userService;
    private ModelMapper modelMapper;

    public UserFriendsBean() {
    }

    @Inject
    public UserFriendsBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        String id = (String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("user-id");

        this.userServiceModel = this.userService.findUserById(id)
                .getFriends()
                .stream()
                .map(f -> this.modelMapper.map(f, UserServiceModel.class))
                .collect(Collectors.toList());
    }

    public List<UserServiceModel> getUserServiceModel() {
        return this.userServiceModel;
    }

    public void setUserServiceModel(List<UserServiceModel> userServiceModel) {
        this.userServiceModel = userServiceModel;
    }

    public void deleteFriend(String id) {
        String loggedInUser =(String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("user-id");

        this.userService.deleteFollow(loggedInUser, id);
        this.redirect("/home");
    }
}
