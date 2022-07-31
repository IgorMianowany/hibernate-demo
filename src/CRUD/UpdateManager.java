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

            Employee employee1 = new Employee("Igor", "Mianowany", "Firma");
            Employee employee2 = new Employee("Filip", "Mianowany", "Firma");
            Employee employee3 = new Employee("Filip", "Kurczewski", "Firma");

            manager.add(employee1);
            manager.add(employee2);
            manager.add(employee3);

            System.out.println("Manager's employees: " + manager.getEmployeeList());

            session.save(employee1);
            session.save(employee2);
            session.save(employee3);


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
