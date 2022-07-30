package CRUD;

import entity.Manager;
import entity.ManagerDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateManager {

    public static void createManager() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(ManagerDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            Manager manager = new Manager("Jan", "Kurczewski", "Kurczewscy");
            ManagerDetail detail = new ManagerDetail("Transport","Zeglowanie");
            manager.setManager_detail_id(detail);

            session.save(manager);

            System.out.println("Created manager: " + manager);

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
