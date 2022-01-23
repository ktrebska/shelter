package pl.edu.java.wszib.shelter.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity(name = "tfinishedrequest")
public class FinishedRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Dog> requestList = new HashSet<>();
    private LocalDateTime date;

    public FinishedRequest(int id, User user, Status status, Set<Dog> requestList, LocalDateTime date) {
        this.id = id;
        this.user = user;
        this.status = status;
        this.requestList = requestList;
        this.date = date;
    }

    public FinishedRequest(User user, Set<Dog> requestList) {
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

    public Set<Dog> getRequestList() {
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
