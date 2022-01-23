package pl.edu.java.wszib.shelter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.java.wszib.shelter.database.Database;
import pl.edu.java.wszib.shelter.database.IDogDAO;
import pl.edu.java.wszib.shelter.model.Dog;
import pl.edu.java.wszib.shelter.service.IAdoptionService;
import pl.edu.java.wszib.shelter.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AdoptionService implements IAdoptionService {

    @Autowired
    IDogDAO dogDAO;

    @Resource
    SessionObject sessionObject;

    public void requestDogAdoption (int dogId) {
        Optional<Dog> dogBox = this.dogDAO.getDogById(dogId);

        if(dogBox.isEmpty()) {
            return;
        }

        Dog dog = dogBox.get();
        if(!(dog.isAdoptable())) {
            return;
        }

        for(Dog dogs : this.sessionObject.getRequestList().getRequestList()) {
            if(dogs.getId() == dog.getId()) {
                return;
            }
        }

        this.sessionObject.getRequestList().getRequestList().add(dog);
    }
}
