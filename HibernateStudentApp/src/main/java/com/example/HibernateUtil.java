package com.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {

            Configuration configuration = new Configuration();

            configuration.setProperty(
                    "hibernate.connection.driver_class",
                    "com.mysql.cj.jdbc.Driver"
            );

            configuration.setProperty(
                    "hibernate.connection.url",
                    "jdbc:mysql://db01.dbhost.dev:5051/db_455bwphfd"
            );

            configuration.setProperty(
                    "hibernate.connection.username",
                    "user_455bwphfd"
            );

            configuration.setProperty(
                    "hibernate.connection.password",
                    "YOUR_DATABASE_PASSWORD"
            );

            configuration.setProperty(
                    "hibernate.dialect",
                    "org.hibernate.dialect.MySQLDialect"
            );

            configuration.setProperty(
                    "hibernate.hbm2ddl.auto",
                    "update"
            );

            configuration.setProperty(
                    "hibernate.show_sql",
                    "true"
            );

            configuration.addAnnotatedClass(Student.class);

            sessionFactory = configuration.buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}