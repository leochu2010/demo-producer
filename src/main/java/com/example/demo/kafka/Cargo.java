package com.example.demo.kafka;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;

public class Cargo {

    private static final Faker faker = new Faker();

    private LocalDateTime localDateTime = LocalDateTime.now();
    private String name = faker.name().fullName();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String streetAddress = faker.address().streetAddress();
    private String producerAddress;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getProducerAddress() {
        return producerAddress;
    }

    public void setProducerAddress(String producerAddress) {
        this.producerAddress = producerAddress;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "localDateTime=" + localDateTime +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", producerAddress='" + producerAddress + '\'' +
                '}';
    }
}
