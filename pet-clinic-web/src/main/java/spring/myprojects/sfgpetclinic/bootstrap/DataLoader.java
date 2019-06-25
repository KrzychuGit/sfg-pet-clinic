package spring.myprojects.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.myprojects.sfgpetclinic.model.Owner;
import spring.myprojects.sfgpetclinic.model.Vet;
import spring.myprojects.sfgpetclinic.services.OwnerService;
import spring.myprojects.sfgpetclinic.services.VetService;


@Component
public class DataLoader implements CommandLineRunner {


    private final VetService vetService;
    private final OwnerService ownerService;

    public DataLoader(VetService vetService, OwnerService ownerService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) throws Exception {


        Owner owner1= new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Grzegorz");
        owner1.setLastName("Kowalczyk");
        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Zofia");
        owner2.setLastName("Tokarczyk");
        ownerService.save(owner2);

        System.out.println("Saved owners...");

        Vet vet1= new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Filip");
        vet1.setLastName("Gogola");
        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Anna");
        vet2.setLastName("Pierz");
        vetService.save(vet2);

        System.out.println("Loaded vets...");



    }
}
