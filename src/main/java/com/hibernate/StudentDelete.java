package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.SelectionQuery;

import javax.sound.midi.Track;
import java.util.List;

public class StudentDelete {
    public static void main(String[] args) {
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session s= sf.openSession();
        Transaction tx= s.beginTransaction();

        //Method1

        StudentPojo stud=new StudentPojo();
        stud.setSno(111);
        s.remove(stud);

        //Method2

//        StudentPojo stud=s.get(StudentPojo.class,222); // this is using primary key.
//        s.remove(stud);

        //Method3 -- Deleting multiple persistent objects. means deleting record of student whose marks is >=600.

        SelectionQuery<StudentPojo> query= s.createSelectionQuery("from StudentPojo where marks>=:marks", StudentPojo.class);
        query.setParameter("marks",600.0);

//    Method4
//        List<StudentPojo>studList=query.list();
//        for (StudentPojo studd: studList){
//            s.remove(studd);
//        }

        tx.commit();
        s.close();
    }
}
