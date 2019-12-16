package cookbook.service;

import cookbook.domain.models.service.UserServiceModel;

import java.util.List;

public interface UserService {

    void userRegister (UserServiceModel userServiceModel);

    UserServiceModel userLogin (UserServiceModel userServiceModel);

    UserServiceModel findUserByUsername (String username);

    UserServiceModel findUserIdByUsername(String username);

    List<UserServiceModel> findAllUsers();

    UserServiceModel findUserById(String id);

    void deleteFollow (String user_id, String friend_id);

    boolean addFriend(UserServiceModel userServiceModel);
}
