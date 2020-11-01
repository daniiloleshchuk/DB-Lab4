package com.lab;

import com.lab.view.MainView;

import java.sql.*;
import java.util.Scanner;

public class Application {


    public static void main(String[] args) {
        new MainView().show();
    }





    /*
    private static final String url = "jdbc:mysql://localhost:3306/oleshchuk_db?serverTimezone=UTC&useSSL=false" +
            "&allowPublicKeyRetrieval=true";
    private static final String user = "user";
    private static final String password = "password";

    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet rs = null;


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            printAllData();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
           if (rs != null) {
               try {
                   rs.close();
               } catch (SQLException throwables) {
                    throwables.printStackTrace();
               }
           }
           if (statement != null) {
               try {
                   statement.close();
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
           }
           if (connection != null) {
               try {
                   connection.close();
               } catch (SQLException throwables) {
                   throwables.printStackTrace();
               }
           }
        }
    }



    private static void printAllData() throws SQLException {

        String query="SELECT id, " +
                "name, " +
                "surname, " +
                "(SELECT `name` from oleshchuk_db.working_position wp where employee.working_position_id=wp.id) working_position " +
                "from oleshchuk_db.employee;";
        rs=statement.executeQuery(query);

        System.out.format("\nTable employee\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %3s | %-25s | %-20s | %-20s |\n", "id", "surname", "name", "working_position");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        while (rs.next())
        {
            int id=rs.getInt("id");
            String surname = rs.getString("surname");
            String name = rs.getString("name");
            String workingPosition = rs.getString("working_position");

            System.out.format("| %3s | %-25s | %-20s | %-20s |\n", id, surname, name, workingPosition);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");




        query = "SELECT * FROM oleshchuk_db.equipment_location";
        rs=statement.executeQuery(query);

        System.out.format("\nTable equipment_location\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %3s | %-25s | %-20s | %-20s |\n", "id", "office", "room_number", "working_place_number");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        while (rs.next())
        {
            int id=rs.getInt("id");
            String office = rs.getString("office");
            String roomNumber = rs.getString("room_number");
            String workingPlaceNumber = rs.getString("working_place_number");

            System.out.format("| %3s | %-25s | %-20s | %-20s |\n", id, office, roomNumber, workingPlaceNumber);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");





        query = "SELECT id, " +
                "(SELECT name FROM oleshchuk_db.employee e WHERE ie.employee_id=e.id) name, " +
                "(SELECT surname FROM oleshchuk_db.employee e WHERE ie.employee_id=e.id) surname " +
                "FROM oleshchuk_db.initiating_employee ie;";
        rs=statement.executeQuery(query);

        System.out.format("\nTable initiating_employee\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %3s | %-25s | %-20s |\n", "id", "name", "surname");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        while (rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");

            System.out.format("| %3s | %-25s | %-20s |\n", id, name, surname);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");




        query="SELECT * FROM oleshchuk_db.priority ORDER BY id";
        rs=statement.executeQuery(query);

        System.out.format("\nTable priority\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %3s | %-25s |\n", "id", "level");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        while (rs.next())
        {
            int id = rs.getInt("id");
            String level = rs.getString("level");

            System.out.format("| %3d | %-25s |\n", id, level);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");





        query="SELECT id, " +
                "(SELECT name FROM oleshchuk_db.employee e WHERE ie.employee_id=e.id) name, " +
                "(SELECT surname FROM oleshchuk_db.employee e WHERE ie.employee_id=e.id) surname " +
                "FROM oleshchuk_db.responsible_employee ie;";
        rs=statement.executeQuery(query);

        System.out.format("\nTable responsible_employee\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %3s | %-25s | %-20s |\n", "id", "name", "surname");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        while (rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");

            System.out.format("| %3d | %-25s | %-20s |\n", id, name, surname);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        */

    /*
        SELECT id, description, creation_date,
         CONCAT((SELECT name FROM employee WHERE employee.id=(SELECT employee_id FROM initiating_employee WHERE s.initiating_employee_id=initiating_employee.id)), "  ", (SELECT surname FROM employee WHERE employee.id=(SELECT employee_id FROM initiating_employee WHERE s.initiating_employee_id=initiating_employee.id))) initiating_employee,
         CONCAT((SELECT office FROM equipment_location el WHERE s.equipment_location_id=el.id), " ", (SELECT room_number FROM equipment_location el WHERE s.equipment_location_id=el.id), " ", (SELECT working_place_number FROM equipment_location el WHERE s.equipment_location_id=el.id)) equipment_location,
         (SELECT name FROM status WHERE s.status_id=status.id) status,
         (SELECT level FROM priority WHERE s.priority_id=priority.id) priority,
         CONCAT((SELECT name FROM employee WHERE employee.id=(SELECT employee_id FROM responsible_employee WHERE s.responsible_employee_id=responsible_employee.id)), "  ", (SELECT surname FROM employee WHERE employee.id=(SELECT employee_id FROM responsible_employee WHERE s.responsible_employee_id=responsible_employee.id))) responsible_employee,
         (SELECT name FROM type_of_statement t WHERE t.id=s.type_of_statement_id) type_of_statement

        FROM statement s;
    */
        /*
        query="SELECT id, " +
                "description, " +
                "creation_date, " +
                "CONCAT(" +
                    "(SELECT name FROM oleshchuk_db.employee WHERE employee.id=" +
                        "(SELECT employee_id FROM oleshchuk_db.initiating_employee WHERE s.initiating_employee_id=initiating_employee.id)" +
                    ")," +
                    " \" \", " +
                    "(SELECT surname FROM oleshchuk_db.employee WHERE employee.id= " +
                        "(SELECT employee_id FROM oleshchuk_db.initiating_employee WHERE s.initiating_employee_id=initiating_employee.id)" +
                    ")" +
                ") initiating_employee," +
                "CONCAT(" +
                    "(SELECT office FROM oleshchuk_db.equipment_location el WHERE s.equipment_location_id=el.id), " +
                    " \" \", " +
                    "(SELECT room_number FROM oleshchuk_db.equipment_location el WHERE s.equipment_location_id=el.id), " +
                    " \" \", " +
                    "(SELECT working_place_number FROM oleshchuk_db.equipment_location el WHERE s.equipment_location_id=el.id)" +
                ") equipment_location," +
                "(SELECT name FROM oleshchuk_db.status WHERE s.status_id=status.id) status," +
                "(SELECT level FROM  oleshchuk_db.priority WHERE s.priority_id=priority.id) priority," +
                "CONCAT(" +
                    "(SELECT name FROM oleshchuk_db.employee WHERE employee.id=" +
                        "(SELECT employee_id FROM oleshchuk_db.responsible_employee WHERE s.responsible_employee_id=oleshchuk_db.responsible_employee.id)" +
                    ")," +
                    " \" \", " +
                    "(SELECT surname FROM oleshchuk_db.employee WHERE employee.id=" +
                        "(SELECT employee_id FROM oleshchuk_db.responsible_employee WHERE s.responsible_employee_id=responsible_employee.id))" +
                    ") responsible_employee," +
                "(SELECT name FROM oleshchuk_db.type_of_statement t WHERE t.id=s.type_of_statement_id) type_of_statement " +
                "FROM oleshchuk_db.statement s";
        rs=statement.executeQuery(query);

        // 4. Process the result set
        System.out.format("\nTable Statement\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %3s | %-25s | %-20s | %-20s | %-20s | %-15s | %-10s | %-20s | %-25s |\n", "id",
                "description", "creation_date", "initiating_employee", "equipment_location", "status", "priority",
                "responsible_employee", "type_of_statement");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        while (rs.next())
        {
            int id = rs.getInt("id");
            String description = rs.getString("description");
            String creationDate = rs.getString("creation_date");
            String initiatingEmployee = rs.getString("initiating_employee");
            String equipmentLocation = rs.getString("equipment_location");
            String status = rs.getString("status");
            String priority = rs.getString("priority");
            String responsibleEmployee = rs.getString("responsible_employee");
            String typeOfStatement = rs.getString("type_of_statement");

            System.out.format("| %3d | %-25s | %-20s | %-20s | %-20s | %-15s | %-10s | %-20s | %-25s |\n", id,
                    description,
                    creationDate,
                    initiatingEmployee,
                    equipmentLocation,
                    status, priority, responsibleEmployee, typeOfStatement);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }




        query="SELECT * FROM oleshchuk_db.status ORDER BY id;";
        rs=statement.executeQuery(query);

        // 4. Process the result set
        System.out.format("\nTable status\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %3s | %-25s |\n", "id", "name");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        while (rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");

            System.out.format("| %3d | %-25s |\n", id, name);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");




        query="SELECT * FROM oleshchuk_db.type_of_statement ORDER BY id;";
        rs=statement.executeQuery(query);

        // 4. Process the result set
        System.out.format("\nTable type_of_statement\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %3s | %-25s |\n", "id", "name");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        while (rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");

            System.out.format("| %3d | %-25s |\n", id, name);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");





        query="SELECT * FROM oleshchuk_db.working_position ORDER BY id";
        rs=statement.executeQuery(query);

        System.out.format("\nTable working_position\n");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %3s | %-25s |\n", "id", "name");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        while (rs.next())
        {
            int id = rs.getInt("id");
            String name = rs.getString("name");

            System.out.format("| %3d | %-25s |\n", id, name);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private static void insertDataCity() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a new name city: ");
        String newcity = input.next();

        // 3. executing SELECT query
        //   PreparedStatements can use variables and are more efficient
        PreparedStatement preparedStatement;
        preparedStatement=connection.prepareStatement("INSERT city VALUES (?)");
        preparedStatement.setString(1, newcity);
        int n=preparedStatement.executeUpdate();
        System.out.println("Count rows that inserted: "+n);

    }
     */
}
