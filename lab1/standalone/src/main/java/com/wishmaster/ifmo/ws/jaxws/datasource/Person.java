package com.wishmaster.ifmo.ws.jaxws.datasource;

import java.util.StringJoiner;

public class Person {
    private String name;
    private String surname;
    private int age;
    private String street;
    private int house;

    public Person() {
    }

    public Person(String name, String surname, int age, String street, int house) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.street = street;
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("surname='" + surname + "'")
            .add("age=" + age)
            .add("street='" + street + "'")
            .add("house=" + house)
            .toString();
    }
}