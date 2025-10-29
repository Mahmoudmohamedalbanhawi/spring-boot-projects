package org.example;

import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class GellAllRecords {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {

            session.beginTransaction();
            Query query = session.createQuery("from User" , User.class);
            List<User> allUsers = query.getResultList();
           for (User user:allUsers)
           {
               System.out.println(user.getUserName());
           }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
