package com.niloy.hibernatedemo.model;

import java.time.LocalDate;
import java.util.List;

public class Employee extends Person {
    private long employeeId;
    private LocalDate joiningDate;
    private Rank rank;

    public Employee(){
        super();
    }

    public Employee(long employeeId) {
        super();
        this.employeeId = employeeId;
    }

    public Employee(Name name, List<Address> addressList, List<Phone> phoneList, Sex sex, LocalDate dateOfBirth, long employeeId) {
        super(name, addressList, phoneList, sex, dateOfBirth);
        this.employeeId = employeeId;
    }

    public Employee(Name name, List<Address> addressList, List<Phone> phoneList, Sex sex, LocalDate dateOfBirth, long employeeId, LocalDate joiningDate, Rank rank) {
        super(name, addressList, phoneList, sex, dateOfBirth);
        this.employeeId = employeeId;
        this.joiningDate = joiningDate;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", joiningDate=" + joiningDate +
                ", rank=" + rank +
                ", " + super.toString() +
                '}';
    }
}
