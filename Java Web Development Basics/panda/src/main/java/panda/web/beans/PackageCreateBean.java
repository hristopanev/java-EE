package panda.web.beans;

import org.modelmapper.ModelMapper;
import panda.domain.models.binding.PackageCreateBindingModel;
import panda.service.PackageService;
import panda.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class PackageCreateBean {

    private List<String> users;
    private PackageCreateBindingModel model;

    private PackageService packageService;
    private UserService userService;
    private ModelMapper modelMapper;

    @Inject
    public PackageCreateBean(PackageService packageService, UserService userService, ModelMapper modelMapper) {
        this.packageService = packageService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.initUsers();
        this.initModel();
    }

    private void initModel() {
        this.model = new PackageCreateBindingModel();
    }

    private void initUsers() {
        this.users = this.userService.findAllUsers().stream().map(u -> u.getUsername()).collect(Collectors.toList());
    }

    public List<String> getUsers() {
        return this.users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public PackageCreateBindingModel getModel() {
        return this.model;
    }

    public void setModel(PackageCreateBindingModel model) {
        this.model = model;
    }

    public void create() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
    }
}
