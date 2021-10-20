package data;

import java.util.Date;

// A Cat object that has many attributes.
// It can have many configurations to represent their breed.
public class Cat {
    private final String name;
    private final Date dateOfBirth;
    private final Nature nature;
    private final String owner;
    private final CatColor color;
    private final Gender gender;

    public Cat(String name, Date dateOfBirth, Nature nature, String owner, CatColor color, Gender gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nature = nature;
        this.owner = owner;
        this.color = color;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + ", dateOfBirth=" + dateOfBirth + ", nature=" + nature +
                ", owner='" + owner + '\'' + ", color=" + color + ", gender=" + gender + '}';
    }
}