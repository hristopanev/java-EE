package repository;


import domain.entites.Submission;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class SubmissionRepositoryImpl implements SubmissionRepository {

    private final EntityManager entityManager;

    @Inject
    public SubmissionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Submission save(Submission submission) {

        this.entityManager.getTransaction().begin();
            this.entityManager.persist(submission);
        this.entityManager.getTransaction().commit();


        return submission;
    }

    @Override
    public Submission findById(String id) {

        this.entityManager.getTransaction().begin();
            Submission submission = this.entityManager.createQuery(
                    "SELECT  s FROM Submission s WHERE s.id = :id", Submission.class)
                    .setParameter("id", id)
                    .getSingleResult();
        this.entityManager.getTransaction().commit();
        return submission;
    }

    @Override
    public List<Submission> findAll() {

        this.entityManager.getTransaction().begin();
            List<Submission> submissions = this.entityManager
                    .createQuery("SELECT s FROM Submission s", Submission.class)
                    .getResultList();
        this.entityManager.getTransaction().commit();

        return submissions;
    }

    @Override
    public List<Submission> findAllProblemSubmissions(String id) {
        this.entityManager.getTransaction().begin();
            List<Submission> submissions = this.entityManager
                    .createQuery("SELECT s FROM Submission s WHERE s.problem.id = :id", Submission.class)
                    .setParameter("id", id)
                    .getResultList();
        this.entityManager.getTransaction().commit();

        return submissions;
    }
}
