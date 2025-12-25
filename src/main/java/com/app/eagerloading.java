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

            Student st = session.get(Student.class,43);
            if(st != null) {
                System.out.println(st);
                System.out.println(st.getScity());
                System.out.println(st.getSid());
                System.out.println(st.getScity());
            }
            else{
                System.out.println("the data is not found in the table");
            }
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }
}
