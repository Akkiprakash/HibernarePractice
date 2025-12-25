package com.app;

import com.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class level1chaching {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = null;
        Session session1 = null;
        try{
            session = sessionFactory.openSession();
            session1 = sessionFactory.openSession();

            Student st = session.get(Student.class,2);
            Student st1 = session.get(Student.class,2);
            System.out.println(st);
            System.out.println(st1);

            Student student = session1.get(Student.class,3);
            Student student1 = session1.get(Student.class,3);
            System.out.println(student1);

            System.out.println(student);

        }
        catch (HibernateException e ){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            session1.close();

        }
    }
}
