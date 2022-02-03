package pl.edu.java.wszib.shelter.dto;


public class DogDto {
    private String name;
    private String breed;

    private int id;
    private int age;
    private boolean isAdoptable;

    public DogDto(String name, String breed, int id, int age, boolean isAdoptable) {
        this.name = name;
        this.breed = breed;
        this.id = id;
        this.age = age;
        this.isAdoptable = isAdoptable;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DogDto() {
    }

    public String getName() { return name; }

    public String getBreed() { return breed; }

    public int getId() { return id; }

    public int getAge() { return age; }

    public boolean isAdoptable() { return isAdoptable; }

    public void setAdoptable(boolean adoptable) { this.isAdoptable = adoptable; }

    public void setId(int id) { this.id = id; }
}
