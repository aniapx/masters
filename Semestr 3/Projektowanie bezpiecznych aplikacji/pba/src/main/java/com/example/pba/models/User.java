package com.example.pba.models;

import com.example.users.Citizenship;
import jakarta.validation.constraints.*;

public class User {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @PositiveOrZero
    private int age;

    @Size(min = 11, max = 11)
    private String pesel;

    @Pattern(regexp = "PL|DE|EN")
    private String citizenship;

    @Email
    private String email;
    public User(String firstName, String lastName, int age, String pesel, String citizenship, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.pesel = pesel;
        this.citizenship = citizenship;
        this.email = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void main(String[] args) {
        // Example usage
        User user = new User("John", "Doe", 30, "12345678901", "PL", "john.doe@example.com");

        // Accessing and printing user information
        System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Age: " + user.getAge());
        System.out.println("PESEL: " + user.getPesel());
        System.out.println("Citizenship: " + user.getCitizenship());
        System.out.println("Email: " + user.getEmail());
    }
}
