package org.example;

import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.time.LocalDate;

public class DeleteRecord {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("Delete from User where id =:id ");
            query.setParameter("id" , 2);
            int rows = query.executeUpdate();

            session.getTransaction().commit();
            System.out.println("deleted rows " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
