package service;

import domain.entites.Package;
import domain.entites.Status;
import domain.models.service.PackageServiceModel;

import java.util.List;

public interface PackageService {

    void createPackage(PackageServiceModel packageServiceModel);

    List<PackageServiceModel> findAllPackages();

    List<PackageServiceModel> findAllPackageByStatus(Status status);

    void packageStatusChange(Package aPackage);

    PackageServiceModel findById(String id);
}
