package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        try{

            System.out.println("Connecting to DB: " + jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl,user,user);

            System.out.println("Connected");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
