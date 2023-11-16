package ru.fitness.application;

import java.time.LocalDate;

public class Client {
    private String lastName;
    private String firstName;
    private final int yearOfBirth;

    public Client(String lastName, String firstName, int yearOfBirth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.yearOfBirth = yearOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }



    @Override
    public String toString() {
        return lastName + " " + firstName + " (" + yearOfBirth + ")";
    }
}
