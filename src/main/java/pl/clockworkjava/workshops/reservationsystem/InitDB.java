package pl.clockworkjava.workshops.reservationsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.clockworkjava.workshops.reservationsystem.domain.guest.GuestService;

@Component
public class InitDB implements CommandLineRunner {

    @Autowired
    GuestService guestService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(" ---- INIT GUEST DATABASE ---- ");

        guestService.createNewGuest("Pawel", "Cwik", 34);

        System.out.println(" ---- CURRENT GUEST COUNT: " + guestService.getAll().size());



    }
}
