package com.perscholas.model;

import javax.persistence.*;

@Entity
@Table
public class Address {
    // class-level, global attributes/variables
    @Id
    @GeneratedValue ( strategy= GenerationType.IDENTITY)
    private int addressID;
    private String streetNumber;
    private String city;
    private String state;
    private int zipcode;
    private String country;

    public Address() {
    }

    public Address(int addressID, String streetNumber, String city, String state, int zipcode, String country) {
        this.addressID = addressID;
        this.streetNumber = streetNumber;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
