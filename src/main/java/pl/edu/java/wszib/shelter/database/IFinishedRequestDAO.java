package pl.edu.java.wszib.shelter.database;

import pl.edu.java.wszib.shelter.model.FinishedRequest;

import java.util.List;

public interface IFinishedRequestDAO {
    void addFinishedRequest(FinishedRequest finishedRequest);
    List<FinishedRequest> getFinishedRequestsByUserId(int userId);
}
