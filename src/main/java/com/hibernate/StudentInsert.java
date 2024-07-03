package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentInsert {
    public static void main(String[] args) {
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session s= sf.openSession();
        Transaction tx= s.beginTransaction();
        StudentPojo stud= new StudentPojo();
        stud.setSno(111);
        stud.setSname("Rahul");
        stud.setMarks(500.0);

        s.persist(stud); //insert into StudentInfo values (?,?,?)
        tx.commit();
        s.close();
    }
}
