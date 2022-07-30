import CRUD.*;
import entity.Employee;
import entity.Manager;
import entity.ManagerDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(ManagerDetail.class)
                .addAnnotatedClass(Manager.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        final Scanner input = new Scanner(System.in);
        String choice;
        while(true){
            System.out.println("Menu:\n" +
                    "1.Read employee\n" +
                    "2.Create employee\n" +
                    "3.Update employee\n" +
                    "4.Delete employee\n" +
                    "5.Query all employees\n" +
                    "6.Custom query\n" +
                    "7.Perform manager stuff\n" +
                    "8.Clear database\n" +
                    "9.Exit");

            choice = input.nextLine();

            if(choice.equals("9")){
                break;
            }

            switch (choice){
                case "8":{
                    ClearDatabase.clearDatabase();
                    break;
                }
                case "1":{
                    System.out.println("Employee id: ");
                    choice = input.nextLine();
                    ReadEmployee.getEmployee(Integer.parseInt(choice));
                    break;
                }
                case "2":{
                    System.out.println("Employee first name: ");
                    String firstName = input.nextLine();

                    System.out.println("Employee last name: ");
                    String lastName = input.nextLine();

                    System.out.println("Company: ");
                    String company = input.nextLine();

                    CreateEmployee.createEmployee(firstName, lastName, company);
                    break;
                }
                case "3":{
                    System.out.println("Input only fields you want to change");
                    System.out.println("Employee id: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.println("Employee first name: ");
                    String firstName = input.nextLine();

                    System.out.println("Employee last name: ");
                    String lastName = input.nextLine();

                    System.out.println("Employee company: ");
                    String company = input.nextLine();

                    UpdateEmployee.updateEmployee(id, firstName, lastName, company);
                    break;
                }
                case "4":{
                    System.out.println("Employee to delete id: ");
                    int id = input.nextInt();
                    input.nextLine();
                    DeleteEmployee.deleteEmployee(id);
                    break;
                }
                case "5":{
                    System.out.println(ReadEmployee.getAllEmployees());
                    break;
                }
                case "6":{
                    System.out.println("Input your query: ");
                    choice = input.nextLine();

                    QueryEmployees.query(choice);
                    break;
                }
                case "7":{
                    System.out.println("menu:\n" +
                            "1.Create Janeczek\n" +
                            "2.Delete Janeczek\n" +
                            "3.Get every manager\n" +
                            "4.Get manager from manager detail id");
                    choice = input.nextLine();
                    switch (choice){
                        case "1":{
                            CreateManager.createManager();
                            break;
                        }
                        case "2":{
                            System.out.println("Manager to delete id: ");
                            int id = input.nextInt();
                            input.nextLine();
                            try(factory){
                                DeleteManager.deleteManager(id);
                            }
                            break;
                        }
                        case "3":{
                            ReadManager.readEveryManager();
                            break;
                        }
                        case "4":{
                            System.out.println("Manager detail id: ");
                            int id = input.nextInt();
                            input.nextLine();
                            ReadManager.readManagerFromDetailId(id);
                            break;
                        }
                    }
                    break;
                }

            }
        }

    }
}
