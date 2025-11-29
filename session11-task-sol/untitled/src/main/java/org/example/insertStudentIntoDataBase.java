package org.example;

import org.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class insertStudentIntoDataBase {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try
        {
            Student student = new Student(1 , "mahmoud" , "mohamed");
            Student student2 = new Student(2 , "Yousef" , "ahmed");
            session.beginTransaction();

            session.save(student2);
            session.getTransaction().commit();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
}