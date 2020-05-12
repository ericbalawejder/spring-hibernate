package com.mappings.hibernate.demo;

import com.mappings.hibernate.demo.entity.Course;
import com.mappings.hibernate.demo.entity.Instructor;
import com.mappings.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor instructor = new Instructor(
                    "Chad", "Darby", "darby@luv2code.com");

            InstructorDetail instructorDetail = new InstructorDetail(
                            "http://www.luv2code.com/youtube", "Luv 2 code!!!");

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);

            // start a transaction
            session.beginTransaction();
            // save the instructor
            // Note: this will ALSO save the details object because of CascadeType.ALL
            System.out.println("Saving instructor: " + instructor);
            session.save(instructor);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
