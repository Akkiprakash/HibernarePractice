package com.app;


import com.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class firstapp {
    public static void main(String[] args) {
 // step 1 create the configuration object
        Configuration config = new Configuration();

        // step 2
        ///  cofigure the entire using congigure method

        config.configure();

        //step 3
        ///  Build the session Factory
        SessionFactory sessionFactory = config.buildSessionFactory();
        // step 4
        ///  getting the session object from the session Factory

        Session session = sessionFactory.openSession();

        // step 5
        ///  non select type we have to use the transcation

        Transaction trancation = session.beginTransaction();
        ///  step 6 operation using the object

        Student st = new Student();
        st.setSid(1);
        st.setSname("Akki");
        st.setScity("Warangal");

        // step 7 to save the student object in the session

        session.save(st);  // it is replicated till the hibernate 5 it works

        trancation.commit();

        ///  close the resource or session or session factory
        session.close();

        // this is the base project of using the hibernate








    }
}
