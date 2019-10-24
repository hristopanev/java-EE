package repository;

import domain.entites.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl extends BaseRepository implements UserRepository {

    private final EntityManager entityManager;

    @Inject
    protected UserRepositoryImpl(EntityManager entityManager, EntityManager entityManager1) {
        super(entityManager);
        this.entityManager = entityManager1;
    }

    @Override
    public User findByUsername(String username) {
        return this.executeTransaction((em) -> {
            return (User) em.createNativeQuery("SELECT * FROM users WHERE  username = '" + username + "'", User.class)
                    .getSingleResult();
        });
    }

    @Override
    public User save(User user) {
        return this.executeTransaction((em) -> {
            em.persist(user);
            return user;
        });
    }

    @Override
    public List<User> findAll() {
        return this.executeTransaction((em) -> {
            return em.createNativeQuery("SELECT * FROM users", User.class)
                    .getResultList();
        });
    }

    @Override
    public User findById(String id) {
        return this.executeTransaction((em) -> {
            return (User) em.createNativeQuery("SELECT * FROM users WHERE id = '" + id + "'", User.class)
                    .getSingleResult();
        });
    }


    @Override
    public void delete(String id) {
        this.executeTransaction((em) -> {
            em.createNativeQuery("DELETE FROM users u WHERE u.id = '" + id + "'", User.class)
                    .executeUpdate();
            return null;
        });
    }

    @Override
    public User update(User user) {
        this.entityManager.getTransaction().begin();

        try {
            User updateUser = this.entityManager.merge(user);
            this.entityManager.getTransaction().commit();

            return updateUser;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();

            return null;
        }
    }

    @Override
    public Long size() {
        this.entityManager.getTransaction().begin();

        Long size = this.entityManager
                .createQuery("SELECT count(u) FROM User u", Long.class)
                .getSingleResult();
        this.entityManager.getTransaction().commit();

        return size;
    }
}