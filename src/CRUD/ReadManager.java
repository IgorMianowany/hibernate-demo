package CRUD;

import entity.Manager;
import entity.ManagerDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadManager {


    public static void readManager(int id){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(ManagerDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            System.out.println(session.get(Manager.class, id));

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

    public static void readManagerFromDetailId(int detailId){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(ManagerDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            ManagerDetail managerDetail = session.get(ManagerDetail.class, detailId);

            System.out.println(managerDetail.getManager());

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

    public static void readEveryManager() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Manager.class)
                .addAnnotatedClass(ManagerDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Manager> managers = session.createQuery("from Manager", Manager.class).getResultList();

            System.out.println(managers);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();

        }
    }
}

