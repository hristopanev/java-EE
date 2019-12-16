package cookbook.repository;

import cookbook.domain.entities.User;

import java.util.List;

public interface UserRepository extends GenericRepository<User, String>  {

    User findByUsername(String username);

    User findUserIdByUsername(String username);

    void deleteUserFriend(String user_id, String friend_id);
}
