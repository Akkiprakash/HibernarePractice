package com.app;

import com.model.Student;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


///  trancasation is need when we operate non select operation ddl

/*
 but in the select commands we didnt use the beginTranscation
 directly we use the operation

 /// Data Retrival


//// single row operation
 */


public class GetrecordApp {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = null;
        try{
           session  = sessionFactory.openSession();
           ///  using the data retrival
        Student student =session.get(Student.class,2);
            System.out.println(student);
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {

            session.close();
            sessionFactory.close();
        }

    }
}
