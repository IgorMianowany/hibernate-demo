package CRUD;

import entity.Employee;
import entity.Manager;
import entity.ManagerDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadEmployee {

    public static Employee getEmployee(int id){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(ManagerDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try(factory){
            session.beginTransaction();

            Employee employee = session.get(Employee.class, id);

            System.out.println(employee);

            session.getTransaction().commit();

            return employee;
        }
    }

    public static List<Employee> getAllEmployees(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try(factory){
            session.beginTransaction();

            List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();


            session.getTransaction().commit();

            return employees;
        }
    }
}
