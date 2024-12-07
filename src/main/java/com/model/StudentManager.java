package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

/**
 * Manages student data operations using Hibernate.
 */
public class StudentManager {

    /**
     * Inserts a student into the database.
     * 
     * @param student The student object to be inserted.
     * @return A message indicating the result of the operation.
     */
    public String insertData(Student student) {
        SessionFactory sessionFactory = null;
        Session session = null;

        try {
            // Create session factory and session
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            session = sessionFactory.openSession();
            
            // Begin transaction
            session.getTransaction().begin();
            
            // Persist student object
            session.persist(student);
            
            // Commit the transaction
            session.getTransaction().commit();
            
            return "Data Inserted Successfully.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        } finally {
            // Close session and session factory
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    /**
     * Retrieves all students from the database.
     * 
     * @return A list of all students.
     */
    public List<Student> getAllStudents() {
        SessionFactory sessionFactory = null;
        Session session = null;
        List<Student> students = null;

        try {
            // Create session factory and session
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            session = sessionFactory.openSession();
            
            // Begin transaction
            session.getTransaction().begin();
            
            // Fetch all students
            Query<Student> query = session.createQuery("FROM Student", Student.class);
            students = query.list();
            
            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close session and session factory
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }

        return students;
    }
}
