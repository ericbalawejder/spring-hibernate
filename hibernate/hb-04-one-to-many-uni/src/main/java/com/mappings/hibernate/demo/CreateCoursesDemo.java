package com.mappings.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mappings.hibernate.demo.entity.Course;
import com.mappings.hibernate.demo.entity.Instructor;
import com.mappings.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

    public static void main(String[] args) throws CloneNotSupportedException {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            int theId = 1;
            Instructor instructor = session.get(Instructor.class, theId);

            // create some courses
            Course course1 = new Course("Air Guitar - The Ultimate Guide");
            Course course2 = new Course("The Pinball Masterclass");

            instructor.add(course1);
            instructor.add(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
