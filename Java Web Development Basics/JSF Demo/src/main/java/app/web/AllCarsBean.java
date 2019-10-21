package app.web;

import app.domain.models.service.CarServiceModel;
import app.service.CarService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AllCarsBean {

    private List<CarServiceModel> cars;
    private CarService carService;

    public AllCarsBean() {
    }

    @Inject
    public AllCarsBean(CarService carService) {
        this.carService = carService;
    }

    @PostConstruct
    private void init() {
        this.setCars(this.carService.allCars());
    }


    public List<CarServiceModel> getCars() {
        return this.cars;
    }

    public void setCars(List<CarServiceModel> cars) {
        this.cars = cars;
    }
}
