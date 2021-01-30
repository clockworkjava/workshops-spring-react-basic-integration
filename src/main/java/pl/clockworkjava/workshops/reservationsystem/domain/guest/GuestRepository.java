package pl.clockworkjava.workshops.reservationsystem.domain.guest;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class GuestRepository {

    //CRUD

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(Guest guest) {
        em.persist(guest);
    }

    @Transactional
    public void update(Guest guest) {
        em.merge(guest);
    }

    public Guest findById(long guestId) {
        return em.find(Guest.class, guestId);
    }

    public List<Guest> getAll() {
        return em
                .createQuery("Select guest from Guest guest", Guest.class)
                .getResultList();
    }

    @Transactional
    public void delete(Guest guest) {
        em.remove(guest);
    }
}
