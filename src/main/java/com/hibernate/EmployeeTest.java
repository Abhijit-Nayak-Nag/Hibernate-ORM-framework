package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session s= sf.openSession();
        Transaction tx= s.beginTransaction();

        Employee emp= new Employee();
        Employee emp1= new Employee();
        emp.setEmpId(140);
        emp.setEmpName("Ashok");
        emp.setEmpSalary(5000);
        emp1.setEmpId(144);
        emp1.setEmpName("Puchan");
        emp1.setEmpSalary(37000);
        s.persist(emp);
        s.persist(emp1);
        tx.commit();
        s.close();

        //printing the 2- object value that we have stored in our table
        System.out.println(emp);
        System.out.println(emp1);

        // if you want to see all the records that are present in your employeeinfo table
        // then take a list and store all the records inside the list and iterate through the for-loop.
    }
}

