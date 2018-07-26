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
        Employee employee = new Employee(new Name("John", "H.", "Doe"),
                addressList,
                phoneList,
                Sex.MALE,
                LocalDate.of(1993, Month.APRIL, 15),
                1225,
                LocalDate.of(2017, Month.JULY, 22),
                Rank.SALES_PERSON);

        Phone phone = new Phone("02", "88", "5429658");
        employee.getPhoneList().add(phone);
        Address address = new Address("Kafrul", "Dhaka", "Bangladesh", "1206");
        employee.getAddressList().add(address);

        System.out.println(employee);

        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(phone);
            session.save(address);
            session.save(employee);
            transaction.commit();
            System.out.println("Committed Transaction Successfully!");
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
    }
    public static void main(String args[]){
        System.out.println("Hello World!");
        new Main();
    }
}
