package repository;

import entity.Location;

import javax.persistence.EntityManager;
import java.util.List;

public class LocationRepository extends BaseRepository<Location> {

    public LocationRepository(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Location findById(int id) {
        return em.find(Location.class, id);
    }

    @Override
    public List<Location> findAll() {
        return em.createQuery("select l from Location l", Location.class).getResultList();
    }
}
