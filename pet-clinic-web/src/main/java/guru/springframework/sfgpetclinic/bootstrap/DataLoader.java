package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    public DataLoader(OwnerService ownerService, VetService vetService){
//        ownerService = new OwnerMapService();
//vetService = new VetMapService();
        this.ownerService = ownerService;
        this.vetService = vetService;
    }
    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("West");
        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("jas");
        owner2.setLastName("b");
        ownerService.save(owner2);

        System.out.println("loading owners");
        Vet vet1 = new Vet();
        vet1.setFirstName("tua");
        vet1.setLastName("sarkar");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("misthun");
        vet2.setLastName("sarkar");
        vetService.save(vet2);

        System.out.println("loading vets");
    }
}
