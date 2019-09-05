package services.implementations;

import entities.User;
import services.UsersService;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UsersServiceImpl implements UsersService {

    private final EntityManager entityManager;

    public UsersServiceImpl() {
        this.entityManager = Persistence.createEntityManagerFactory("usersdb")
                .createEntityManager();
    }

    @Override
    public List<User> getAllUsers() {
        // SELECT * FROM users;
        CriteriaQuery<User> query =
                entityManager.getCriteriaBuilder()
                .createQuery(User.class);

        query.from(User.class);

        List<User> result = entityManager.createQuery(query)
                .getResultList();

        return result;
    }

    @Override
    public void add(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
}
