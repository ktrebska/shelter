package pl.edu.java.wszib.shelter.model;

public class Dog {
    private String name;
    private String breed;
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

    public String getName() { return name; }

    public String getBreed() { return breed; }

    public int getId() { return id; }

    public int getAge() { return age; }

    public boolean isAdoptable() { return isAdoptable; }

    public void setAdoptable(boolean adoptable) { isAdoptable = adoptable; }

    public void setId(int id) { this.id = id; }

}
