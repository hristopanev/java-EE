package repository;

import domain.entities.Hero;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class HeroRepositoryImpl implements HeroRepository {
    private final EntityManager entityManager;

    @Inject
    public HeroRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Hero save(Hero hero) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(hero);
        this.entityManager.getTransaction().commit();

        return hero;
    }

    @Override
    public Hero findById(String id) {
        this.entityManager.getTransaction().begin();
        Hero hero = this.entityManager.createQuery("SELECT h FROM Hero  h WHERE h.id = :id", Hero.class)
                .setParameter("id", id)
                .getSingleResult();
        this.entityManager.getTransaction().commit();

        return hero;
    }

    @Override
    public List<Hero> findALL() {
        this.entityManager.getTransaction().begin();
        List<Hero> heroes = this.entityManager.createQuery("SELECT h FROM Hero h ORDER BY h.level DESC", Hero.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return heroes;
    }

    @Override
    public void delete(String id) {
        this.entityManager.getTransaction().begin();
        this.entityManager.createQuery("DELETE FROM Hero h WHERE h.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        this.entityManager.getTransaction().commit();
    }
}
