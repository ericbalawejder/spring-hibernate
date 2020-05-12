package com.mappings.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mappings.hibernate.demo.entity.Instructor;
import com.mappings.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int id = 2;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id);

            System.out.println("tempInstructorDetail: " + tempInstructorDetail);
            System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            // handle connection leak issue
            session.close();
            factory.close();
        }
    }

}
