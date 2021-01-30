package pl.clockworkjava.workshops.reservationsystem.domain.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    GuestRepository repository;

    public void createNewGuest(String firstName, String lastName, int age) {
        Guest newOne = new Guest(firstName, lastName, age);
        repository.create(newOne);
    }

    public List<Guest> getAll() {
        return repository.getAll();
    }
}
