package pl.edu.java.wszib.shelter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tdog")
public class Dog {
    private String name;
    private String breed;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private boolean isAdoptable;

    public Dog(String name, String breed, int id, int age, boolean isAdoptable) {
        this.name = name;
        this.breed = breed;
        this.id = id;
        this.age = age;
        this.isAdoptable = isAdoptable;
    }

    public Dog() {
    }

    public String getName() { return name; }

    public String getBreed() { return breed; }

    public int getId() { return id; }

    public int getAge() { return age; }

    public boolean isAdoptable() { return isAdoptable; }

    public void setAdoptable(boolean adoptable) { isAdoptable = adoptable; }

    public void setId(int id) { this.id = id; }

}
