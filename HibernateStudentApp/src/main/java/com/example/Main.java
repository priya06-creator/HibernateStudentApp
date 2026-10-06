package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction transaction = session.beginTransaction();

        // Create Student object
        Student student = new Student();

        student.setId(1);
        student.setName("Priya");
        student.setEmail("priya@gmail.com");
        student.setCourse("Information Technology");

        // Insert student
        session.persist(student);

        transaction.commit();

        System.out.println("Student inserted successfully!");
        System.out.println(student);

        session.close();


        // Update student
        session = HibernateUtil
                .getSessionFactory()
                .openSession();

        transaction = session.beginTransaction();

        Student studentToUpdate =
                session.get(Student.class, student.getId());

        studentToUpdate.setCourse("Computer Science");

        transaction.commit();

        System.out.println("Student updated successfully!");
        System.out.println(studentToUpdate);

        session.close();

        HibernateUtil.getSessionFactory().close();
    }
}