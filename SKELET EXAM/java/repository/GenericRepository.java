package repository;

import java.util.List;

public interface GenericRepository<Entity, Id> {

    Entity save(Entity entity);

    List<Entity> findAll();

    Entity findById(Id id);

    void delete(String id);

    Entity update(Entity entity);
}
