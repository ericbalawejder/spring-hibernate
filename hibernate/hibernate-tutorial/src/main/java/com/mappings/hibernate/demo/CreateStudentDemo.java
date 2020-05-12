package com.mappings.hibernate.demo;

import com.mappings.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.text.ParseException;

public class CreateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            System.out.println("Creating new student object...");

            Student tempStudent = new Student("Welvin", "Deeznuts",
                    "unfiltered@email.com", DateUtils.parseDate("01/01/1970"));

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

}
