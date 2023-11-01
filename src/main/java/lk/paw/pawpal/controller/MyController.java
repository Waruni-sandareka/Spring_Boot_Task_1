package lk.paw.pawpal.controller;

import lk.paw.pawpal.model.Pet;
import lk.paw.pawpal.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    PetService petService;

    @GetMapping("/test")
    public String name(){

        return "Charith Sathsara";
    }

    @GetMapping("/getAllPet")
    public List<Pet> getAllPet(){
        return petService.getAllPet();

    }

    @GetMapping("/getSpecificPet/{id}")
    public Pet getSpecificPet(@PathVariable String id){

        return petService.getSpecificPet(id);
    }

    @PostMapping("/addPet")
    public List<Pet> addPet(@RequestBody Pet pet){
        return petService.addPet(pet);
    }

}
