package service;

import domain.entites.Package;
import domain.models.service.PackageServiceModel;
import org.modelmapper.ModelMapper;
import repository.PackageRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;
    private final ModelMapper modelMapper;



    @Inject
    public PackageServiceImpl(PackageRepository packageRepository, ModelMapper modelMapper) {
        this.packageRepository = packageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createPackage(PackageServiceModel packageServiceModel) {
        Package aPackage = this.modelMapper.map(packageServiceModel, Package.class);
        this.packageRepository.save(aPackage);
    }

    @Override
    public List<PackageServiceModel> findAllPackages() {
        return this.packageRepository.findAll()
                .stream()
                .map(p -> this.modelMapper.map(p, PackageServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public PackageServiceModel findById(String id) {
        return this.modelMapper.map(this.packageRepository.findById(id), PackageServiceModel.class);
    }
}
