package web.beans;

import domain.models.binding.PackageCreateBindingModel;
import domain.models.service.PackageServiceModel;
import org.modelmapper.ModelMapper;
import service.PackageService;
import service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class PackageCreateBean extends BaseBean {

    private List<String> users;
    private PackageCreateBindingModel packageCreateBindingModel;

    private PackageService packageService;
    private UserService userService;
    private ModelMapper modelMapper;

    public PackageCreateBean() {
    }

    @Inject
    public PackageCreateBean(PackageService packageService, UserService userService, ModelMapper modelMapper) {
        this.packageService = packageService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init() {
        this.packageCreateBindingModel = new PackageCreateBindingModel();

        this.users = userService.findAllUsers()
                .stream()
                .map(u -> u.getUsername())
                .collect(Collectors.toList());
    }

    public PackageCreateBindingModel getPackageCreateBindingModel() {
        return this.packageCreateBindingModel;
    }

    public void setPackageCreateBindingModel(PackageCreateBindingModel packageCreateBindingModel) {
        this.packageCreateBindingModel = packageCreateBindingModel;
    }

    public List<String> getUsers() {
        return this.users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public void creatPackage() {
        PackageServiceModel packageServiceModel = this.modelMapper
                .map(this.packageCreateBindingModel, PackageServiceModel.class);

        packageServiceModel
                .setRecipient(userService.findUserByUsername(this.packageCreateBindingModel.getRecipient()));

        this.packageService.createPackage(packageServiceModel);

        redirect("/home");
    }
}
