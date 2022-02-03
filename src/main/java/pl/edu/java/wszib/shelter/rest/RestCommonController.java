package pl.edu.java.wszib.shelter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.java.wszib.shelter.dto.DogDto;
import pl.edu.java.wszib.shelter.dto.UserDto;
import pl.edu.java.wszib.shelter.model.Dog;
import pl.edu.java.wszib.shelter.model.User;
import pl.edu.java.wszib.shelter.service.IAuthenticationService;
import pl.edu.java.wszib.shelter.service.IDogService;
import pl.edu.java.wszib.shelter.session.SessionObject;

import javax.annotation.Resource;

@RestController
public class RestCommonController {

    @Autowired
    IDogService dogService;

    @Autowired
    IAuthenticationService authenticateService;

    @RequestMapping(value = "/dogs/{id}", method = RequestMethod.GET)
    public DogDto getDog(@PathVariable int id) {
        Dog dog = dogService.findById(id);
        DogDto dtoDog = new DogDto();
        dtoDog.setId(dog.getId());
        dtoDog.setAdoptable(dog.isAdoptable());
        dtoDog.setAge(dog.getAge());
        dtoDog.setBreed(dog.getBreed());
        dtoDog.setName(dog.getName());
        return dtoDog;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public UserDto getUser(@PathVariable int id) {
        User user = authenticateService.findUserById(id);
        UserDto dtoUser = new UserDto();
        dtoUser.setId(user.getId());
        dtoUser.setName(user.getName());
        dtoUser.setSurname(user.getSurname());
        dtoUser.setLogin(user.getLogin());
        dtoUser.setPass(user.getPass());
        return dtoUser;
    }

}
