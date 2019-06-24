package spring.myprojects.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.myprojects.sfgpetclinic.model.Owner;
import spring.myprojects.sfgpetclinic.model.Vet;
import spring.myprojects.sfgpetclinic.services.OwnerService;
import spring.myprojects.sfgpetclinic.services.VetService;
import spring.myprojects.sfgpetclinic.services.map.OwnerServiceMap;
import spring.myprojects.sfgpetclinic.services.map.VetServiceMap;


@Component
public class DataLoader implements CommandLineRunner {


    private final VetService vetService;
    private final OwnerService ownerService;

    public DataLoader() {

        ownerService= new OwnerServiceMap();
        vetService= new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {


        Owner owner1= new Owner();
        owner1.setId(1L);
        owner1.setFirsName("Grzegorz");
        owner1.setFirsName("Kowalczyk");
        ownerService.save(owner1);

        Owner owner2= new Owner();
        owner2.setId(2L);
        owner2.setFirsName("Zofia");
        owner2.setFirsName("Tokarczyk");
        ownerService.save(owner2);

        System.out.println("Saved owners...");

        Vet vet1= new Vet();
        vet1.setId(1L);
        vet1.setFirsName("Filip");
        vet1.setFirsName("Gogola");
        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setId(2L);
        vet2.setFirsName("Anna");
        vet2.setFirsName("Pierz");
        vetService.save(vet2);

        System.out.println("Loaded vets...");



    }
}
