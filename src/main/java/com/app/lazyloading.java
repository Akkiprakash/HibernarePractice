package com.app;

import com.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class lazyloading {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = null;
        try{
           session= sessionFactory.openSession();
          // Student st = session.load(Student.class,1);
           ///  we can also use the getreference() afeter the hibernate 6 it works

        Student st = session.getReference(Student.class,2);
        System.out.println(st);
        System.in.read(); // till the pressing the enter the program woukd stop means in the waitning stats
            System.out.println(st.getScity());
            System.out.println( st.getSname());
            System.out.println(  st.getSid());

        }catch (HibernateException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
