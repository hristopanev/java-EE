package app.repositroy;


import app.domain.entities.Car;

import java.util.List;

public interface CarRepository {

    void save(Car car);

    List<Car> getCars();
}
