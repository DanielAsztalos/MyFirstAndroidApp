package com.example.myfirstapp;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String department;

    public Person(String firstName, String lastName) {
        super();

        this.firstName = firstName;
        this.lastName = lastName;
        this.department = "-";
    }

    public Person(String firstName, String lastName, String department) {
        super();

        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
