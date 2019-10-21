package app.web;

import app.domain.models.service.CarServiceModel;
import app.service.CarService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@RequestScoped
public class CreateBean implements Serializable {

    private CarService carService;
    private CarServiceModel carServiceModel;

    public CreateBean() {
    }

    @Inject
    public CreateBean(CarService carService) {
        this.carService = carService;
    }

    @PostConstruct
    private void init() {
        this.carServiceModel = new CarServiceModel();
    }

    public void createCar() throws IOException {
        this.carService.saveCar(this.carServiceModel);

        FacesContext.getCurrentInstance().getExternalContext().redirect("/views/all.jsf");
    }

    public CarServiceModel getCarServiceModel() {
        return this.carServiceModel;
    }

    public void setCarServiceModel(CarServiceModel carServiceModel) {
        this.carServiceModel = carServiceModel;
    }
}
