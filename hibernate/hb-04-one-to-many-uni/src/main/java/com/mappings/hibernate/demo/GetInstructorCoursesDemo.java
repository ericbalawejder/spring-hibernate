package com.mappings.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mappings.hibernate.demo.entity.Course;
import com.mappings.hibernate.demo.entity.Instructor;
import com.mappings.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;
            Instructor instructor = session.get(Instructor.class, theId);

            System.out.println("Instructor: " + instructor);

            // get courses for the instructor
            System.out.println("Courses: " + instructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
