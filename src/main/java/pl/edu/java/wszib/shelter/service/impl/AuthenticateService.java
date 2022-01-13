package pl.edu.java.wszib.shelter.service.impl;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.edu.java.wszib.shelter.database.Database;
import pl.edu.java.wszib.shelter.exceptions.LoginAlreadyUseException;
import pl.edu.java.wszib.shelter.model.User;
import pl.edu.java.wszib.shelter.model.view.RegisterUser;
import pl.edu.java.wszib.shelter.service.IAuthenticationService;
import pl.edu.java.wszib.shelter.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AuthenticateService implements IAuthenticationService {

    @Autowired
    Database database;

    @Resource
    SessionObject sessionObject;

    @Override
    public void authenticate(String login, String password) {
        Optional<User> user = this.database.getUserByLogin(login);

        if(user.isEmpty() ||
                !user.get().getPass().equals(DigestUtils.md5Hex(password))) {
            return;
        }
        this.sessionObject.setUser(user.get());
    }

    @Override
    public void register(RegisterUser registerUser) {
        Optional<User> userBox = this.database.getUserByLogin(registerUser.getLogin());

        if(userBox.isPresent()) {
            throw new LoginAlreadyUseException();
        }

        registerUser.setPass(DigestUtils.md5Hex(registerUser.getPass()));
        this.database.addUser(registerUser);
    }
}
