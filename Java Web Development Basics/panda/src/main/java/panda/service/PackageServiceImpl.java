package panda.service;

import org.modelmapper.ModelMapper;
import panda.domain.models.service.PackageServiceModel;
import panda.repository.PackageRepository;

import javax.inject.Inject;

public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Inject
    public PackageServiceImpl(PackageRepository packageRepository, UserService userService, ModelMapper modelMapper) {
        this.packageRepository = packageRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void packageCreate(PackageServiceModel packageServiceModel) {
        packageServiceModel.setRecipient(this.userService.findUserByUsername(packageServiceModel.getRecipient().getUsername()));
    }
}
