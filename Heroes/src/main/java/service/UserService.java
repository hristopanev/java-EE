package service;

import domain.models.service.UserServiceModel;

public interface UserService {

    UserServiceModel getUserById(String id);

    UserServiceModel getUserByUsername(String username);

    UserServiceModel createUser(UserServiceModel userServiceModel);
}
