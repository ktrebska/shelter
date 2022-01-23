package pl.edu.java.wszib.shelter.database;

import pl.edu.java.wszib.shelter.model.User;

import java.util.Optional;

public interface IUserDAO {
    Optional<User> getUserByLogin(String login);
    void addUser(User user);
    Optional<User> getUserById(int id);
}
