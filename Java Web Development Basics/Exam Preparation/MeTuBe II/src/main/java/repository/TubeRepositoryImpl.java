package repository;

import domain.entites.Tube;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class TubeRepositoryImpl implements TubeRepository {

    private final EntityManager entityManager;

    @Inject
    public TubeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Tube save(Tube tube) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(tube);
        this.entityManager.getTransaction().commit();

        return tube;
    }

    @Override
    public Tube findById(String id) {

        this.entityManager.getTransaction().begin();
        Tube tube = this.entityManager.createQuery("SELECT t FROM Tube  t WHERE t.id =:id", Tube.class)
                .setParameter("id", id)
                .getSingleResult();
        this.entityManager.getTransaction().commit();

        return tube;
    }

    @Override
    public List<Tube> findAll() {

        this.entityManager.getTransaction().begin();
        List<Tube> tubes = this.entityManager.createQuery("SELECT t FROM Tube t", Tube.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return tubes;
    }

    @Override
    public List<Tube> findAllByUserId(String id) {

        this.entityManager.getTransaction().begin();
        List<Tube> tubes = this.entityManager.createQuery("SELECT t FROM Tube t WHERE t.uploader.id = :id", Tube.class)
                .setParameter("id", id)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return tubes;
    }
}
