package pl.edu.java.wszib.shelter.database;

import pl.edu.java.wszib.shelter.model.Dog;

import java.util.List;
import java.util.Optional;

public interface IDogDAO {
    List<Dog> getDogs();
    Optional<Dog> getDogById(int dogId);
    void updateDog(Dog dog);
}
