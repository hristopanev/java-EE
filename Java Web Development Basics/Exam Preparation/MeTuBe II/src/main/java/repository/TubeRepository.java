package repository;

import domain.entites.Tube;

import java.util.List;

public interface TubeRepository {

    Tube save(Tube tube);

    Tube findById(String id);

    List<Tube> findAll();

    List<Tube> findAllByUserId(String id);
}
