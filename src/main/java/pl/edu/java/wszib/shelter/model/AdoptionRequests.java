package pl.edu.java.wszib.shelter.model;

import java.util.ArrayList;
import java.util.List;

public class AdoptionRequests {
    private List<Dog> requestList = new ArrayList<>();

    public List<Dog> getRequestList() { return requestList; }

    public void clearRequestList() {
        this.requestList = new ArrayList<>();
    }
}
