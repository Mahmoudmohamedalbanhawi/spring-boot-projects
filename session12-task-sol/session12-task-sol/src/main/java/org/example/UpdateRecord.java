package org.example;

import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class UpdateRecord {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {

            session.beginTransaction();
            Query query = session.createQuery("update User set userName= :name where id = :id");
            query.setParameter("name" , "youssef");
            query.setParameter("id" , 4);
            int row = query.executeUpdate();
            session.getTransaction().commit();
            System.out.println("update rows " + row);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
