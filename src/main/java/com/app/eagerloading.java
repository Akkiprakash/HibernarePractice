package com.app;

import com.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class eagerloading {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = null;

        try{
            session = sessionFactory.openSession();
            Student st = session.get(Student.class,3);

            System.out.println(st);
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }
}
