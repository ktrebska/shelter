package pl.edu.java.wszib.shelter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.java.wszib.shelter.database.Database;
import pl.edu.java.wszib.shelter.model.Dog;
import pl.edu.java.wszib.shelter.model.FinishedRequest;
import pl.edu.java.wszib.shelter.service.IFinishedRequestService;
import pl.edu.java.wszib.shelter.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class FinishedRequestService implements IFinishedRequestService {
    @Resource
    SessionObject sessionObject;

    @Autowired
    Database database;

    @Override
    public void confirmRequest() {
        FinishedRequest finishedRequest = new FinishedRequest(this.sessionObject.getUser(),
                this.sessionObject.getRequestList().getRequestList());
        if(finishedRequest.getRequestList().isEmpty()){
            return;
        }
        this.database.addFinishedRequest(finishedRequest);
        for (Dog dog : finishedRequest.getRequestList()) {
            Optional<Dog> dogBox = database.getDogById(dog.getId());
        }
        for (Dog dog :  database.getDogs()) {
            if( finishedRequest.getRequestList().contains(dog)){
                dog.setAdoptable(false);
            }
        }
        this.sessionObject.getRequestList().clearRequestList();
    }

    @Override
    public List<FinishedRequest> getFinishedRequestsForCurrentUser() {
        return this.database.getFinishedRequestsByUserId(this.sessionObject.getUser().getId());
    }
}
