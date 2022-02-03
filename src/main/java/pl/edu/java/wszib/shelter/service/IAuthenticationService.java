package pl.edu.java.wszib.shelter.service;

import pl.edu.java.wszib.shelter.model.User;
import pl.edu.java.wszib.shelter.model.view.RegisterUser;

public interface IAuthenticationService {
    void authenticate(String login, String password);
    void register(RegisterUser registerUser);
    public User findUserById(Integer id);
}
