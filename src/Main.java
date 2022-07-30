import CRUD.CreateEmployee;
import CRUD.ReadEmployee;
import CRUD.UpdateEmployee;
import entity.Employee;

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
                    "5.Clear database\n" +
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
            }
        }

    }
}
