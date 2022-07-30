package CRUD;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {

    public static void updateEmployee(int id, String firstName, String lastName, String company){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try(factory){
            session.beginTransaction();

            if(!firstName.isEmpty()){
                session.createQuery("update Employee set first_name='" + firstName + "' where id="+id).executeUpdate();
            }
            if(!lastName.isEmpty()){
                session.createQuery("update Employee set last_name='" + lastName + "' where id="+id).executeUpdate();
            }
            if(!company.isEmpty()){
                session.createQuery("update Employee set company='" + company + "' where id="+id).executeUpdate();
            }

            session.getTransaction().commit();
        }
    }
}
