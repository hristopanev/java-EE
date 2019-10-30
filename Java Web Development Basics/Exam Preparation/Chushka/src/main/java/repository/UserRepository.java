package repository;

import domain.entites.User;
import domain.models.service.UserServiceModel;

public interface UserRepository extends GenericRepository<User, String> {

    Long size();

    User findByUsername(String username);

    void deleteFollowChanel(String channel_id, String friend_id);

    boolean addChannelFollow(UserServiceModel userServiceModel);
}
