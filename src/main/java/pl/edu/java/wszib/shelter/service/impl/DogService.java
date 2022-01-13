package pl.edu.java.wszib.shelter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.java.wszib.shelter.database.Database;
import pl.edu.java.wszib.shelter.model.Dog;
import pl.edu.java.wszib.shelter.service.IDogService;

import java.util.List;

@Service
public class DogService implements IDogService {

    @Autowired
    Database database;

    public List<Dog> getDogs() {
        return this.database.getDogs();
    }
}
