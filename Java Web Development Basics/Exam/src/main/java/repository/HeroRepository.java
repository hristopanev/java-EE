package repository;

import domain.entities.Hero;

import java.util.List;

public interface HeroRepository {

    Hero save(Hero hero);

    Hero findById(String id);

    List<Hero> findALL();

    void delete(String id);
}
