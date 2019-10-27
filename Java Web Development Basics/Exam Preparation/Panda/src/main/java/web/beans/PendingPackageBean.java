package web.beans;

import domain.entites.Package;
import domain.entites.Status;
import domain.models.service.PackageServiceModel;
import domain.models.view.PackageViewModel;
import org.modelmapper.ModelMapper;
import service.PackageService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PendingPackageBean extends BaseBean {

    private List<PackageViewModel> packages;

    private PackageService packageService;
    private ModelMapper modelMapper;

    public PendingPackageBean() {
    }

    @Inject
    public PendingPackageBean(PackageService packageService, ModelMapper modelMapper) {
        this.packageService = packageService;
        this.modelMapper = modelMapper;
    }

}
