package repository;

import domain.entites.JobApp;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class JobRepositoryImpl extends BaseRepository implements JobRepository {

    private final EntityManager entityManager;

    @Inject
    protected JobRepositoryImpl(EntityManager entityManager, EntityManager entityManager1) {
        super(entityManager);
        this.entityManager = entityManager1;
    }

    @Override
    public JobApp save(JobApp jobApp) {
        return this.executeTransaction((em) -> {
            em.persist(jobApp);
            return jobApp;
        });
    }

    @Override
    public List<JobApp> findAll() {
        return this.executeTransaction((em) -> {
            return em.createNativeQuery("SELECT * FROM jobs_app", JobApp.class)
                    .getResultList();
        });
    }

    @Override
    public JobApp findById(String id) {
        return this.executeTransaction((em) -> {
            return (JobApp) em.createNativeQuery("SELECT * FROM jobs_app WHERE id = '"+ id +"'", JobApp.class)
                    .getSingleResult();
        });
    }

    @Override
    public void delete(String id) {
        this.executeTransaction((em) -> {
            em.createNativeQuery("DELETE FROM jobs_app WHERE id = '"+ id +"'", JobApp.class)
                    .executeUpdate();
            return null;
        });
    }

    @Override
    public JobApp update(JobApp jobApp) {
        this.entityManager.getTransaction().begin();

        try {
            JobApp updateUser = this.entityManager.merge(jobApp);
            this.entityManager.getTransaction().commit();

            return updateUser;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();

            return null;
        }
    }
}
