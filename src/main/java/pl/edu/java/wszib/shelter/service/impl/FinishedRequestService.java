package pl.edu.java.wszib.shelter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.java.wszib.shelter.database.Database;
import pl.edu.java.wszib.shelter.database.IDogDAO;
import pl.edu.java.wszib.shelter.database.IFinishedRequestDAO;
import pl.edu.java.wszib.shelter.model.Dog;
import pl.edu.java.wszib.shelter.model.FinishedRequest;
import pl.edu.java.wszib.shelter.service.IFinishedRequestService;
import pl.edu.java.wszib.shelter.session.SessionObject;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class FinishedRequestService implements IFinishedRequestService {
    @Resource
    SessionObject sessionObject;

    @Autowired
    IFinishedRequestDAO finishedRequestDAO;

    @Autowired
    IDogDAO dogDAO;

    @Override
    public void confirmRequest() {
        FinishedRequest finishedRequest = new FinishedRequest(this.sessionObject.getUser(),
                new HashSet<>(this.sessionObject.getRequestList().getRequestList()));
        if(finishedRequest.getRequestList().isEmpty()){
            return;
        }
        this.finishedRequestDAO.addFinishedRequest(finishedRequest);

        for (Dog dog : finishedRequest.getRequestList()) {
            Dog dogBox = this.dogDAO.getDogById(dog.getId());
            dogBox.setAdoptable(false);
            this.dogDAO.updateDog(dogBox);
        }
        this.sessionObject.getRequestList().clearRequestList();
    }

    @Override
    public List<FinishedRequest> getFinishedRequestsForCurrentUser() {
        return this.finishedRequestDAO.getFinishedRequestsByUserId(this.sessionObject.getUser().getId());
    }
}
