package cookbook.web.beans;

import cookbook.domain.models.service.UserServiceModel;
import cookbook.service.UserService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;


@Named
@RequestScoped
public class UserFriendsBean {
    private List<UserServiceModel> models;

    private UserService userService;
    private ModelMapper modelMapper;


    public UserFriendsBean() {
    }

    @Inject
    public UserFriendsBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.initModels();
    }

    private void initModels() {
        String id = (String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("user-id");

        this.models = this.userService.findUserById(id)
                .getFriends()
                .stream()
                .map(f -> this.modelMapper.map(f, UserServiceModel.class))
                .collect(Collectors.toList());
    }

    public List<UserServiceModel> getModels() {
        return models;
    }

    public void setModels(List<UserServiceModel> models) {
        this.models = models;
    }

    public void removeFriend(String id) {


    }

}