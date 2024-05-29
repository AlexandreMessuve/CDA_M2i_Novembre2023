package repository;

import entity.Event;

import javax.persistence.EntityManager;
import java.util.List;

public class EventRepository extends BaseRepository<Event> {
    public EventRepository(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Event findById(int id) {
        return em.find(Event.class, id);
    }

    @Override
    public List<Event> findAll() {
        return em.createQuery("select e from Event e", Event.class).getResultList();
    }
}
