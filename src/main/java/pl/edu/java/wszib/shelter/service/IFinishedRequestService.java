package pl.edu.java.wszib.shelter.service;

import pl.edu.java.wszib.shelter.model.FinishedRequest;

import java.util.List;

public interface IFinishedRequestService {
    void confirmRequest();
    List<FinishedRequest> getFinishedRequestsForCurrentUser();
}
