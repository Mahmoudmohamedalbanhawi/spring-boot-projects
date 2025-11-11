package org.example;

import org.example.model.Answer;
import org.example.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Answer.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            Question question = new Question("Java is Comiled Language ?");
            List<Answer> answers = new ArrayList<>();
            Collections.addAll(answers ,
                    new Answer("Yes"),
                    new Answer("No")
                    );
            question.setAnswers(answers);
            session.save(question);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}