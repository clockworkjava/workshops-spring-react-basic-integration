package pl.clockworkjava.workshops.reservationsystem.domain.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GuestService {

    @Autowired
    GuestRepository repository;

    public Guest createNewGuest(String firstName, String lastName, int age) {
        Guest newOne = new Guest(firstName, lastName, age);
        repository.create(newOne);
        return newOne;
    }

    public List<Guest> getAll() {
        return repository.getAll();
    }

    public Guest getGuestById(Long id) {
        return this.repository.findById(id);
    }

    public void createNewGuest(Guest guest) {
        this.repository.create(guest);
    }

    public void remove(Long id) {
        Guest guest = this.repository.findById(id);
        this.repository.delete(guest);
    }

    public Long fullUpdateGuest(Long id, Guest guest) {

        Guest existing = this.repository.findById(id);

        if(existing==null) {
            this.repository.create(guest);
            existing = guest;
        } else {
            guest.setId(existing.getId());
            this.repository.update(guest);
        }

        return existing.getId();
    }

    public void partialUpdate(Long id, Map<String, Object> updates) {
        Guest existing = this.repository.findById(id);

        if(existing==null) {
            // it will return 500 to client, error mapping out of scope for the example
            throw new IllegalArgumentException("No such ID");
        } else {
            if(updates.containsKey("age")) {
                int newAge = Integer.parseInt(updates.get("age").toString());
                existing.setAge(newAge);
            }
        }
    }
}
