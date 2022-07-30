import CRUD.*;
import entity.Employee;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        CreateEmployee.createEmployee("John", "Doe", "Microsoft");
//        Employee employee = ReadEmployee.getEmployee(1);
//        DeleteEmployee.deleteEmployee(1);
//        ClearDatabase.clearDatabase();
//        UpdateEmployee.updateEmployee(1,"Igor");
        final Scanner input = new Scanner(System.in);
        String choice;
        while(true){
            System.out.println("Menu:\n" +
                    "1.Read employee\n" +
                    "2.Create employee\n" +
                    "3.Update employee\n" +
                    "4.Delete employee\n" +
                    "5.Query all employees\n" +
                    "8.Clear database\n" +
                    "9.Exit");

            choice = input.nextLine();

            if(choice.equals("9")){
                break;
            }

            switch (choice){
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
                case "8":{
                    ClearDatabase.clearDatabase();
                }
            }
        }

    }
}
