package lk.paw.pawpal.service;

import lk.paw.pawpal.model.Pet;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

    List<Pet> petList = new ArrayList<Pet>();

    public PetService(){
        Pet pt1 = new Pet();
        pt1.setName("Sookiri");
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

}
