package com.niloy.hibernatedemo;

import com.niloy.hibernatedemo.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private SessionFactory sessionFactory;

    private void insertEmployee(){
        List<Address> addressList = new ArrayList<>();
        List<Phone> phoneList = new ArrayList<>();
        Employee employee1 = new Employee(new Name("John", "H.", "Doe"),
                addressList,
                phoneList,
                Sex.MALE,
                LocalDate.of(1993, Month.APRIL, 15),
                1225,
                LocalDate.of(2017, Month.JULY, 22),
                Rank.SALES_PERSON);

        Employee employee2 = new Employee(new Name("Joe", "L.", "Doe"),
                addressList,
                phoneList,
                Sex.MALE,
                LocalDate.of(1993, Month.APRIL, 15),
                1226,
                LocalDate.of(2017, Month.JULY, 22),
                Rank.SALES_PERSON);

        Employee employee3 = new Employee(new Name("Jason", "B.", "Doe"),
                addressList,
                phoneList,
                Sex.MALE,
                LocalDate.of(1993, Month.APRIL, 15),
                1227,
                LocalDate.of(2017, Month.JULY, 22),
                Rank.SALES_PERSON);

        Phone phone = new Phone("02", "88", "5429658");
        employee1.getPhoneList().add(phone);
        employee2.getPhoneList().add(phone);
        employee3.getPhoneList().add(phone);
        Address address = new Address("Banani", "Dhaka", "Bangladesh", "1206");
        employee1.getAddressList().add(address);
        employee2.getAddressList().add(address);
        employee3.getAddressList().add(address);

        System.out.println(employee1);

        Department accountsDepartment = new Department("Accounts");
        Department salesDepartment = new Department("Sales");

        employee1.setDepartment(salesDepartment);
        employee2.setDepartment(salesDepartment);
        employee3.setDepartment(accountsDepartment);

        salesDepartment.getEmployeeList().add(employee1);
        salesDepartment.getEmployeeList().add(employee2);
        accountsDepartment.getEmployeeList().add(employee3);

        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(phone);
            session.save(address);
            session.save(accountsDepartment);
            session.save(salesDepartment);
            session.save(employee1);
            session.save(employee2);
            session.save(employee3);
            transaction.commit();
            System.out.println("Committed Transaction Successfully!");
        } catch (HibernateException he){
            transaction.rollback();
            he.printStackTrace();
        }

        session.close();
    }

    private void insertCustomer(){
        List<Address> addressList = new ArrayList<>();
        List<Phone> phoneList = new ArrayList<>();
        Customer customer = new Customer(new Name("Jane", "A.", "Doe"),
                addressList,
                phoneList,
                Sex.MALE,
                LocalDate.of(1994, Month.APRIL, 5),
                5822);

        Phone phone = new Phone("02", "88", "5429658");
        customer.getPhoneList().add(phone);
        Address address = new Address("Kafrul", "Dhaka", "Bangladesh", "1206");
        customer.getAddressList().add(address);

        System.out.println(customer);

        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(phone);
            session.save(address);
            session.save(customer);
            transaction.commit();
            System.out.println("Committed Suscessfully!");
        } catch (HibernateException he){
            transaction.rollback();
            he.printStackTrace();
        }

        session.close();
    }

    public Main(){
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

//        Product product = new Product(3,"Walton", 15000, "Phone");
//
//        Session session = sessionFactory.openSession();
//
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
////            session.save(product);
//            insertEmployee();
//            transaction.commit();
//        } catch (HibernateException he){
//            transaction.rollback();
//        }
//
//        session.close();

        insertEmployee();
        insertCustomer();
    }
    public static void main(String args[]){
        System.out.println("Hello World!");
        new Main();
    }
}
