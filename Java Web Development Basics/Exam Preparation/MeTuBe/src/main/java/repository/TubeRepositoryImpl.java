package repository;

import domain.entites.Tube;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class TubeRepositoryImpl extends BaseRepository implements TubeRepository {

    @Inject
    protected TubeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Tube save(Tube tube) {
        return this.executeTransaction((em) -> {
           em.persist(tube);

           return tube;
        });
    }

    @Override
    public List<Tube> findAll() {
        return this.executeTransaction((em) -> {
            return em.createNativeQuery("SELECT * FROM tubes", Tube.class)
                    .getResultList();
        });
    }

    @Override
    public Tube findById(String id) {
        return this.executeTransaction((em) -> {
            return (Tube) em.createNativeQuery("SELECT * FROM tubes WHERE id = '"+ id +"'")
                    .getSingleResult();
        });
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Tube update(Tube tube) {
        return null;
    }
}
