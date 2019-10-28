package repository;

import domain.entites.Problem;
import domain.models.service.ProblemServiceModel;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class ProblemRepositoryImpl implements ProblemRepository {

    private final EntityManager entityManager;

    @Inject
    public ProblemRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Problem save(Problem problem) {

        this.entityManager.getTransaction().begin();
        this.entityManager.persist(problem);
        this.entityManager.getTransaction().commit();

        return problem;
    }

    @Override
    public Problem findById(String id) {
        this.entityManager.getTransaction().begin();

        Problem problem = this.entityManager.createQuery("SELECT p FROM Problem p WHERE p.id = :id", Problem.class)
                .setParameter("id", id)
                .getSingleResult();
        this.entityManager.getTransaction().commit();


        return problem;
    }

    @Override
    public List<Problem> findAll() {
        this.entityManager.getTransaction().begin();
        List<Problem> problems = this.entityManager
                .createQuery("SELECT p FROM Problem  p", Problem.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return problems;
    }
}
