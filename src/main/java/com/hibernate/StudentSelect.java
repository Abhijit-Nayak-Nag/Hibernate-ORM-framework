package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class StudentSelect {
    public static void main(String[] args) {
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session s= sf.openSession();
        SelectionQuery<StudentPojo> query= s.createSelectionQuery("from StudentPojo", StudentPojo.class);
        List<StudentPojo>studList= query.list();

        for (StudentPojo stud : studList) {
            System.out.println(stud);

        }
        s.close();
    }
}

