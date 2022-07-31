package CRUD;

import entity.Employee;
import entity.Manager;
import entity.ManagerDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateManager {

    public static void addAllEmployeesToManager(int id){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(ManagerDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            Manager manager = session.get(Manager.class,id);

            System.out.println("Manager: " + manager);

            List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();

            employees.forEach(employee -> {
                manager.add(employee);
                employee.setManager(manager);
                session.save(manager);
                session.save(employee);
            });

            System.out.println("Manager's employees: " + manager.getEmployeeList());

            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
