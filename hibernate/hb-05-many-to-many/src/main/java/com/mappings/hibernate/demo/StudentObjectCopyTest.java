package com.mappings.hibernate.demo;

import com.mappings.hibernate.demo.entity.Course;
import com.mappings.hibernate.demo.entity.Instructor;
import com.mappings.hibernate.demo.entity.InstructorDetail;
import com.mappings.hibernate.demo.entity.Review;
import com.mappings.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentObjectCopyTest {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Student james = new Student(
                    "James", "Dolittle", "james@dolittle.com");

            // Prints true with equals() and hashCode().
            System.out.println(james.equals(new Student(james)));

            // Creates two students with different ids
            session.save(james);
            session.save(new Student(james));

            Student bill = new Student(
                    "Bill", "Doe", "bill@doe.com");

            // Creates one student
            session.save(bill);
            session.save(bill);

            System.out.println("Saved student: ");
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
