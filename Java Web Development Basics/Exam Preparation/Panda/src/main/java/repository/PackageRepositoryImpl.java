package repository;

import domain.entites.Package;
import domain.entites.Status;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class PackageRepositoryImpl extends BaseRepository implements PackageRepository {

    private final EntityManager entityManager;

    @Inject
    protected PackageRepositoryImpl(EntityManager entityManager, EntityManager entityManager1) {
        super(entityManager);
        this.entityManager = entityManager1;
    }

    @Override
    public Package save(Package aPackage) {
        return this.executeTransaction((em) -> {
            em.persist(aPackage);
            return aPackage;
        });
    }

    @Override
    public List<Package> findAll() {
        return this.executeTransaction((em) -> {
            return em.createNativeQuery("SELECT * FROM packeges", Package.class)
                    .getResultList();
        });
    }

    @Override
    public Package findById(String id) {
        return this.executeTransaction((em) -> {
            return (Package) em.createNativeQuery("SELECT * FROM packeges WHERE id = '" + id +"'", Package.class)
                    .getSingleResult();
        });
    }

    @Override
    public void delete(String id) {
        this.executeTransaction((em) -> {
            em.createNativeQuery("DELETE FROM packages WHERE id = '"+ id +"'", Package.class);
            return null;
        });
    }

    @Override
    public Package update(Package aPackage) {
        this.entityManager.getTransaction().begin();

        try {
            Package updatePackage = this.entityManager.merge(aPackage);
            this.entityManager.getTransaction().commit();

            return updatePackage;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();

            return null;
        }
    }

    @Override
    public List<Package> findPackageByStatus(Status status) {
        return this.executeTransaction((em) -> {
            return em.createNativeQuery("SELECT * FROM packages WHERE status = '"+ status +"'")
                    .getResultList();
        });
    }
}
