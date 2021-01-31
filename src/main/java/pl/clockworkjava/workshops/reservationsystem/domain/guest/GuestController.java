package pl.clockworkjava.workshops.reservationsystem.domain.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GuestController {

    @Autowired
    GuestService guestService;

    //CRUD
    //HTTP

    // GET /api/guests - pobrac wszystko
    // GET /api/guests/1 - pobierze gościa o ID 1
    @GetMapping("/guests")
    public List<Guest> getAllGuests() {
        return guestService.getAll();
    }

    @GetMapping("/guests/{id}")
    public Guest getGuest(@PathVariable Long id) {
        return guestService.getGuestById(id);
    }

    // POST /api/guests - stwórz gosica
    @PostMapping("/guests")
    public void createGuest(@RequestBody Guest guest) {
        guestService.createNewGuest(guest);
    }

    // DELETE /api/guests/1 - usuń goscia o id 1
    @DeleteMapping("/guests/{id}")
    public void deleteGuest(@PathVariable Long id) {
        guestService.remove(id);
    }

    // PUT /api/guests/1 - zaktualizuj badz utworz goscia o id 1
    @PutMapping("/guests/{id}")
    public void updateGuest(@PathVariable Long id, @RequestBody  Guest guest) {
        this.guestService.updateGuest(id, guest);
    }


}
