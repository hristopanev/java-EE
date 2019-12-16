package cookbook.web.beans;

import cookbook.domain.models.service.UserServiceModel;
import cookbook.service.UserService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class UserAddFriendBean {

    private List<UserServiceModel> models;

    private UserService userService;
    private ModelMapper modelMapper;

    public UserAddFriendBean() {
    }

    @Inject
    public UserAddFriendBean(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.initModels();
    }

    private void initModels() {
        String username = (String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("username");

        String id = (String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("user-id");


        UserServiceModel loggedInUser = this.userService.findUserById(id);

        this.models = this.userService
                .findAllUsers()
                .stream()
                .filter(u -> !u.getUsername().equals(username) &&
                        !loggedInUser.getFriends()
                                .stream()
                                .map(f -> f.getUsername())
                                .collect(Collectors.toList()).contains(u.getUsername()))
                .map(u -> this.modelMapper.map(u, UserServiceModel.class))
                .collect(Collectors.toList());


    }

    public List<UserServiceModel> getModels() {
        return this.models;
    }

    public void setModels(List<UserServiceModel> models) {
        this.models = models;
    }

    public UserServiceModel getUser(String id) throws IOException {
        return this.userService.findUserById(id);
    }

    public void addFriend(String id) throws IOException {

        String loggedInUserId =(String) ((HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(false))
                .getAttribute("user-id");

        UserServiceModel loggedInUser = this.userService.findUserById(loggedInUserId);

        UserServiceModel userServiceModel = this.userService.findUserById(id);

        loggedInUser.getFriends().add(userServiceModel);
//        userServiceModel.getFriends().add(loggedInUser);

        if (!this.userService.addFriend(loggedInUser)) {
            throw new IllegalArgumentException("Something went wrong!");
        }

//        if (!this.userService.addFriend(userServiceModel)) {
//            throw new IllegalArgumentException("Something went wrong!");
//        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/views/home.xhtml");
    }

}
