package repository;

import entity.Ticket;

import javax.persistence.EntityManager;
import java.util.List;

public class TicketRepository extends BaseRepository<Ticket> {
    public TicketRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Ticket findById(int id) {
        return em.find(Ticket.class, id);
    }

    @Override
    public List<Ticket> findAll() {
        return em.createQuery("select t from Ticket t", Ticket.class).getResultList();
    }


}
