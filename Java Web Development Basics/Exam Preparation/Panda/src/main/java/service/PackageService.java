package service;

import domain.models.service.PackageServiceModel;

import java.util.List;

public interface PackageService {

    void createPackage(PackageServiceModel packageServiceModel);

    List<PackageServiceModel> findAllPackages();

    PackageServiceModel findById(String id);
}
