package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class StudentUpdate {
    public static void main(String[] args) {
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session s= sf.openSession();
        Transaction tx= s.beginTransaction();

        //Method1

        StudentPojo stud=s.get(StudentPojo.class,111); //select * from StudentInfo where sno=111; first we get the value from table, and then we update the value of marks to 555.0. generally get() method works on primary key.
        stud.setMarks(555.0);
        s.merge(stud); // by using session object once you call the method merge() the object will get updated and then just commit your transaction and close your session.

        //Method2 - Using HQL(Hibernate Query Language) - applied on model (Class), not on table.
        MutationQuery query= s.createMutationQuery("update StudentPojo set marks=:marks where sname=:sname");
        query.setParameter("marks", 650.0);
        query.setParameter("sname","Raj");
        query.executeUpdate();

        tx.commit();
        s.close();
//in hibernate everything we played with class and object only but finally result is happen in tables only. because we have mapped our class name with the table name.
    }
}
