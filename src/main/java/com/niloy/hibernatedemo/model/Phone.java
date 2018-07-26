package com.niloy.hibernatedemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Phone {
    @Id
    @GeneratedValue
    private int phoneId;
    private String countryCode;
    private String areaCode;
    private String number;

    public Phone() {
    }

    public Phone(String countryCode, String areaCode, String number) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.number = number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "countryCode='" + countryCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
