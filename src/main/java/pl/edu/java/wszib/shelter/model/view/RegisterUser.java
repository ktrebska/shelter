package pl.edu.java.wszib.shelter.model.view;

import pl.edu.java.wszib.shelter.model.User;

public class RegisterUser extends User {
    private String password2;

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
