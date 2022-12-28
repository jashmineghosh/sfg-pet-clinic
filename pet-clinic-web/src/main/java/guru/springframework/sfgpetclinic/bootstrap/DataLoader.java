package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService){
//        ownerService = new OwnerMapService();
//vetService = new VetMapService();
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }
    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0)loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("West");
        owner1.setAddress("c1 dayal");
        owner1.setCity("lisbon");
        owner1.setTelephone("1234545667");
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("miko");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("jas");
        owner2.setLastName("b");
        owner1.setAddress("roseville");
        owner1.setCity("bangalore");
        owner1.setTelephone("222222222");
        Pet jasPet = new Pet();
        jasPet.setPetType(savedCatPetType);
        jasPet.setOwner(owner1);
        jasPet.setBirthDate(LocalDate.now());
        jasPet.setName("jasPetName");
        owner1.getPets().add(jasPet);
        ownerService.save(owner2);

        System.out.println("loading owners");
        Vet vet1 = new Vet();
        vet1.setFirstName("tua");
        vet1.setLastName("sarkar");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("misthun");
        vet2.setLastName("sarkar");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("loading vets");
    }
}
