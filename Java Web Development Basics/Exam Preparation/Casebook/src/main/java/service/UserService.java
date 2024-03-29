package service;

import domain.models.service.UserServiceModel;

import java.util.List;

public interface UserService {

    void userRegister(UserServiceModel userServiceModel);

    UserServiceModel userLogin(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsername(String username);

    List<UserServiceModel> findAllUsers();

    UserServiceModel findUserById(String id);

    boolean addFriend(UserServiceModel userServiceModel);

    void deleteFollow (String user_id, String friend_id);
}
