package cookbook.repository;

import cookbook.domain.entities.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserRepositoryImpl extends BaseRepository implements UserRepository {

    private final EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager, EntityManager entityManager1) {
        super(entityManager);
        this.entityManager = entityManager1;
    }

    @Override
    public User findByUsername(String username) {
        this.entityManager.getTransaction().begin();
        try {
            User user = this.entityManager
                    .createQuery("SELECT u FROM User  u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
            this.entityManager.getTransaction().commit();

            return user;
        }catch (Exception e){
            this.entityManager.getTransaction().commit();
            return null;
        }
    }

    @Override
    public User save(User user) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(user);
        this.entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public List<User> findAll() {
        this.entityManager.getTransaction().begin();
        List<User> users = this.entityManager
                .createQuery("SELECT u FROM User u", User.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return users;
    }

    @Override
    public User findById(String id) {
        this.entityManager.getTransaction().begin();
        User user = this.entityManager
                .createQuery("SELECT u FROM User  u WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
        this.entityManager.getTransaction().commit();

        return user;
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

    @Override
    public void delete(String id) {
        this.executeTransaction((em) -> {
            em.createNativeQuery("DELETE  FROM User WHERE id = '"+ id +"'").executeUpdate();
            return null;
        });
    }

    @Override
    public void deleteUserFriend(String userID, String friendID) {


        this.executeTransaction((em) -> {
            em.createNativeQuery("DELETE  FROM `cookingbook_db`.`users_friends` WHERE user_id = '"+ userID +"' AND friend_id = '" + friendID + "'")
                    .executeUpdate();
            return null;
        });
    }

    @Override
    public User findUserIdByUsername(String username) {
        this.entityManager.getTransaction().begin();
        User user = this.entityManager
                .createQuery("SELECT u.id FROM User  u WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
        this.entityManager.getTransaction().commit();

        return user;
    }

    @Override
    public User update(User user) {
        this.entityManager.getTransaction().begin();

        try {
            User updateUser = this.entityManager.merge(user);
        this.entityManager.getTransaction().commit();

        return updateUser;
        }catch (Exception e) {
            this.entityManager.getTransaction().rollback();

         return null;
        }
    }
}
