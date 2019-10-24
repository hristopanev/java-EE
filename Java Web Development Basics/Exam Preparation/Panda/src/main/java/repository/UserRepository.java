package repository;

import domain.entites.User;

public interface UserRepository extends GenericRepository<User, String> {

    User findByUsername(String username);

    Long size();
}
