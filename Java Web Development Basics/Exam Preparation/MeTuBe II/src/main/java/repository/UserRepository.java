package repository;

import domain.entites.User;

import java.util.List;

public interface UserRepository {

    User save(User entity);

    List<User> findAll();

    User findById(String id);

    Long size();

    User findByUsername(String username);

    void delete(String id);

    User update(User entity);
}
