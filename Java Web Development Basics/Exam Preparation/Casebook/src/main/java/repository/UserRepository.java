package repository;

import domain.entites.User;

public interface UserRepository extends GenericRepository<User, String> {

    User findByUsername(String username);

    void deleteFriend(String userID, String friendID);
}
