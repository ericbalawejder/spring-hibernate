package com.mappings.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mappings.hibernate.demo.entity.Instructor;
import com.mappings.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // get instructor by primary key / id
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            System.out.println("Found instructor: " + instructor);

            // delete the instructors
            if (instructor != null) {
                System.out.println("Deleting: " + instructor);
                // Note: will ALSO delete associated "details" object because of CascadeType.ALL
                session.delete(instructor);
            }
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

}
