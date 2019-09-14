package panda.repository;

import panda.domain.entities.Package;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class PackageRepositoryImpl implements PackageRepository {

    private final EntityManager entityManager;

    @Inject
    public PackageRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Package save(Package entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public List<Package> findAll() {
        this.entityManager.getTransaction().begin();
        List<Package> packages= this.entityManager
                .createQuery("SELECT p FROM User  p", Package.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return packages;
    }

    @Override
    public Package findById(String id) {
        this.entityManager.getTransaction().begin();
        Package packages= this.entityManager
                .createQuery("SELECT p FROM User p WHERE p.id =:id", Package.class)
                .setParameter("id", id)
                .getSingleResult();
        this.entityManager.getTransaction().commit();

        return packages;
    }

    @Override
    public Long size() {
        this.entityManager.getTransaction().begin();
        Long size = this.entityManager
                .createQuery("SELECT count(p) FROM Package p", Long.class)
                .getSingleResult();
        this.entityManager.getTransaction().commit();

        return size;
    }
}
