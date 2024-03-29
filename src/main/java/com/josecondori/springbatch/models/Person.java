package com.josecondori.springbatch.models;

public class Person {

    private String name;
    private String lastname;
    private String dni;

    public Person() {}

    public Person(String name, String lastname, String dni) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
