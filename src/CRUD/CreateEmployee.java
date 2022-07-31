package CRUD;

import entity.Employee;
import entity.Manager;
import entity.ManagerDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployee {

    public static void createEmployee(String firstName, String lastName, String company) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(ManagerDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try(factory){
            session.beginTransaction();

            Employee tempEmployee = new Employee(firstName, lastName, company);

            session.save(tempEmployee);

            System.out.println("Created employee: " + tempEmployee);

            session.getTransaction().commit();
        }
    }

}
