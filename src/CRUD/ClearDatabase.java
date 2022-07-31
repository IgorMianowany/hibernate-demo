package CRUD;

import entity.Employee;
import entity.Manager;
import entity.ManagerDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClearDatabase {

    public static void clearDatabase(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(ManagerDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try(factory){
            session.beginTransaction();


            session.createSQLQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
            session.createSQLQuery("truncate table Employee").executeUpdate();
            session.createSQLQuery("truncate table Manager").executeUpdate();
            session.createSQLQuery("truncate table Manager_Detail").executeUpdate();
            session.createSQLQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();


            session.getTransaction().commit();
        }

    }
}
