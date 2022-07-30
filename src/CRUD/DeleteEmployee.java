package CRUD;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {

    public static void deleteEmployee(int employeeId){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try(factory){
            session.beginTransaction();

            session.createQuery("delete from Employee where id =" + employeeId).executeUpdate();


            session.getTransaction().commit();
        }

    }

    public static void deleteEmployee(String firstName, String lastName, String company){

    }
}
