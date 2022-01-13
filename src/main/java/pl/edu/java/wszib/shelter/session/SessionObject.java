package pl.edu.java.wszib.shelter.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.java.wszib.shelter.model.AdoptionRequests;
import pl.edu.java.wszib.shelter.model.User;

@Component
@SessionScope
public class SessionObject {
    private User user = null;
    final AdoptionRequests requestList = new AdoptionRequests();

    public boolean isLogged() {
        return this.user != null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AdoptionRequests getRequestList() { return requestList; }
}
