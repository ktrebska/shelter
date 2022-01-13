package pl.edu.java.wszib.shelter.database;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import pl.edu.java.wszib.shelter.model.Dog;
import pl.edu.java.wszib.shelter.model.FinishedRequest;
import pl.edu.java.wszib.shelter.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Database {

    private List<Dog> dogs = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<FinishedRequest> finishedRequests = new ArrayList<>();

    private Database() {
        dogs.add(new Dog("Lana", "spaniel", 1, 5, true));
        dogs.add(new Dog("Luna", "mieszaniec", 2, 3, true));
        dogs.add(new Dog("Bobi", "jamnik", 3, 2, true));
        dogs.add(new Dog("Fafik", "mieszaniec", 4, 0, true));
        dogs.add(new Dog("Reksio", "mieszaniec", 5, 11, true));

        users.add(new User(1, "Kasia", "Trebska", "admin", DigestUtils.md5Hex("admin")));
        users.add(new User(2, "Arek", "Kowalski", "user", DigestUtils.md5Hex("user")));
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public Optional<User> getUserByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public Optional<Dog> getDogById(int dogId) {
        for(Dog dog : this.dogs) {
            if(dog.getId() == dogId) {
                return Optional.of(dog);
            }
        }
        return Optional.empty();
    }

    public void addUser(User user) {
        this.users.add(user);
    }
    public void addFinishedRequest(FinishedRequest finishedRequest) {
        this.finishedRequests.add(finishedRequest);
    }

    public List<FinishedRequest> getFinishedRequestsByUserId(int userId) {
        List<FinishedRequest> result = new ArrayList<>();
        for(FinishedRequest finishedRequest : this.finishedRequests) {
            if(finishedRequest.getUser().getId() == userId) {
                result.add(finishedRequest);
            }
        }

        return result;
    }

}
