package app.repositroy;

import app.domain.entities.Car;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {

    private final EntityManager entityManager;
    private final ModelMapper modelMapper;

    @Inject
    public CarRepositoryImpl(EntityManager entityManager, ModelMapper modelMapper) {
        this.entityManager = entityManager;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(Car car) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(car);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List<Car> getCars() {
        this.entityManager.getTransaction().begin();
        List<Car> cars = this.entityManager.createQuery("SELECT c FROM Car  c", Car.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return cars;
    }
}
