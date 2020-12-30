package models;

import enums.GenderType;

public class User {

    private String FirstName;
    private String LastName;
    private GenderType Gender;

    public User() {
    }

    public User(String firstName, String lastName, GenderType gender) {
        FirstName = firstName;
        LastName = lastName;
        Gender = gender;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public GenderType getGender() {
        return Gender;
    }

    public void setGender(GenderType gender) {
        Gender = gender;
    }
}

