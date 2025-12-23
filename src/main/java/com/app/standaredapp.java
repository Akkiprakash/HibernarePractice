package com.app;

import com.model.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class standaredapp {
    public static void main(String[] args) {

        Configuration config = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        config = new Configuration();
        config.configure();
        sessionFactory = config.buildSessionFactory();

        session = sessionFactory.openSession();

        Student st = new Student();
        st.setScity("adilabad");
        st.setSname("akkis");
        st.setSid(2);

        try{
            transaction = session.beginTransaction();

            session.persist(st);
            flag = true;
        }catch (HibernateException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
           if(flag ==  true){
               transaction.commit();
           }
           else{
               transaction.rollback();
           }
           session.close();
           sessionFactory.close();
        }
    }
}
