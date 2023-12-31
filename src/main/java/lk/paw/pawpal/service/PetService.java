package lk.paw.pawpal.service;

import lk.paw.pawpal.model.Pet;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PetService {

    List<Pet> petList = new ArrayList<Pet>();

    public PetService(){
        Pet pt1 = new Pet();
        pt1.setName("Sookiriya");
        pt1.setId("001");
        pt1.setBreed("Cat");

        Pet pt2 = new Pet();
        pt2.setName("Teady");
        pt2.setId("002");
        pt2.setBreed("Dog");


        petList.add(pt1);
        petList.add(pt2);
    }

    public List<Pet> getAllPet(){

        return petList;
    }

    public Pet getSpecificPet(String id){

        return petList.stream().filter(s-> s.getId().equals(id)).findFirst().get();
    }

    public List<Pet> addPet(Pet pet){
        return Stream.of(pet).collect(Collectors.toCollection(()->petList));

    }

    public String updatePet(Pet pet){
        try {
            petList.stream().filter(p -> p.getId().equals(pet.getId())).forEach(p -> {
                p.setName(pet.getName());
                p.setBreed(pet.getBreed());
            });
            return "Successfully updated";
        }
        catch (Exception e){
            return "Error Occured";

        }

    }

    public String deletePet(String id){
        boolean result = petList.removeIf(p->p.getId().equals(id));
        if(result)
            return "Successfully deleted" +id;
        else
            return "Something went wrong";
    }

}
