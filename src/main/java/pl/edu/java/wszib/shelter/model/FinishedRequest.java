package pl.edu.java.wszib.shelter.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FinishedRequest {
    private int id;
    private User user;
    private Status status;
    private List<Dog> requestList = new ArrayList<>();
    private LocalDateTime date;

    public FinishedRequest(int id, User user, Status status, List<Dog> requestList, LocalDateTime date) {
        this.id = id;
        this.user = user;
        this.status = status;
        this.requestList = requestList;
        this.date = date;
    }

    public FinishedRequest(User user, List<Dog> requestList) {
        this.id = new Random().nextInt(1000000);
        this.user = user;
        this.status = Status.NEW;
        this.requestList = requestList;
        date = LocalDateTime.now();
    }

    public FinishedRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Dog> getRequestList() {
        return requestList;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public enum Status {
        NEW,
        ACCEPTED,
        DENIED
    }
}
