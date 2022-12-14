package CRUD;

import entity.Employee;
import entity.Manager;
import entity.ManagerDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteManager {

    public static void deleteManager(int id) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(ManagerDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
//            Manager manager = session.get(Manager.class, id);
//            session.delete(manager);
            session.createQuery("delete from Manager where id="+id);
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
