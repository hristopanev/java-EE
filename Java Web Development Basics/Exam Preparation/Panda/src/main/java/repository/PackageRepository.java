package repository;

import domain.entites.Package;
import domain.entites.Status;

import java.util.List;

public interface PackageRepository extends GenericRepository<Package, String> {

    List<Package> findPackageByStatus(Status status);
}
