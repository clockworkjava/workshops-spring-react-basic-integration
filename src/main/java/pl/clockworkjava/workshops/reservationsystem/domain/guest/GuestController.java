package pl.clockworkjava.workshops.reservationsystem.domain.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
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
    @ResponseStatus(HttpStatus.CREATED)
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
    public ResponseEntity<Void> updateGuest(@PathVariable Long id, @RequestBody  Guest guest) {
        Long updatedId = this.guestService.fullUpdateGuest(id, guest);

        if(updatedId==id) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.created(URI.create("guests/"+updatedId)).build();
        }
    }

    @PatchMapping("/guests/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchGuests(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
        this.guestService.partialUpdate(id, updates);
    }


}
