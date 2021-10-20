package director;

import builder.Builder;
import data.Cat;
import data.Gender;
import data.Nature;

import java.util.Date;

// Execute the building process in a particular sequence,
// The Director class is optional and it might be omitted in some use-cases.
public class Director {
    // Create a cat named Alex from the given builder.
    // In this case, the client will pass a builder object to alter the implementation.
    // So Alex might be a black cat or calico cat.
    public Cat createCat(Builder builder) {
        builder.addName("Alex");
        builder.addDateOfBirth(new Date(1634651257263L));
        builder.addGender(Gender.MALE);
        builder.addNature(Nature.CALM);
        builder.addOwner("Cynthia");
        return builder.build();
    }
}
