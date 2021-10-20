package builder;

import data.Cat;
import data.Gender;
import data.Nature;

import java.util.Date;

/**
 * Builder class with default implementation of common build methods.
 */
public abstract class Builder {
    protected String name;
    protected Date dateOfBirth;
    protected Nature nature;
    protected String owner;
    protected Gender gender = Gender.FEMALE;

    // methods that add variations to the final product
    public void addName(String name) { this.name = name; }
    public void addDateOfBirth(Date date) { this.dateOfBirth = date; }
    public void addNature(Nature nature) { this.nature = nature; }
    public void addOwner(String owner) { this.owner = owner; }
    public void addGender(Gender gender) { this.gender = gender; }

    // Produce Cat object
    public abstract Cat build();
}