package com.niloy.hibernatedemo.model;

import java.time.LocalDate;
import java.util.List;

public class Person {
    private Name name;
    private List<Address> addressList;
    private List<Phone> phoneList;
    private Sex sex;
    private LocalDate dateOfBirth;

    public Person() {
    }

    public Person(Name name, List<Address> addressList, List<Phone> phoneList, Sex sex, LocalDate dateOfBirth) {
        this.name = name;
        this.addressList = addressList;
        this.phoneList = phoneList;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", addressList=" + addressList +
                ", phoneList=" + phoneList +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
