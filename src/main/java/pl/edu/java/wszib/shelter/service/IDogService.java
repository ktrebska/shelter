package pl.edu.java.wszib.shelter.service;

import pl.edu.java.wszib.shelter.model.Dog;

import java.util.List;
import java.util.Optional;

public interface IDogService {
    List<Dog> getDogs();


    Dog findById(Integer id);
}
