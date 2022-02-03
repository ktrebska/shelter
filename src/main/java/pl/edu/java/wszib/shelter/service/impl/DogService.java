package pl.edu.java.wszib.shelter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.java.wszib.shelter.database.IDogDAO;
import pl.edu.java.wszib.shelter.model.Dog;
import pl.edu.java.wszib.shelter.service.IDogService;

import java.util.List;
import java.util.Optional;

@Service
public class DogService implements IDogService {

    @Autowired
    IDogDAO dogDAO;

    public List<Dog> getDogs() {
        return this.dogDAO.getDogs();
    }


    public Dog findById(Integer id){
        return this.dogDAO.getDogById(id);
    }
}
