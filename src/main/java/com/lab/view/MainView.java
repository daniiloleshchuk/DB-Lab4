package com.lab.view;

import com.lab.controller.implementation.*;
import com.lab.model.implementation.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {
    private final EmployeeController employeeController = new EmployeeController();
    private final EquipmentLocationController equipmentLocationController = new EquipmentLocationController();
    private final InitiatingEmployeeController initiatingEmployeeController = new InitiatingEmployeeController();
    private final PriorityController priorityController = new PriorityController();
    private final ResponsibleEmployeeController responsibleEmployeeController = new ResponsibleEmployeeController();
    private final StatementController statementController = new StatementController();
    private final StatusController statusController = new StatusController();
    private final TypeOfStatementController typeOfStatementController = new TypeOfStatementController();
    private final WorkingPositionController workingPositionController = new WorkingPositionController();

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private static final Scanner input = new Scanner(System.in);

    public MainView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("11", "11 - Get all employees");
        menu.put("12", "12 - Get employee by ID");
        menu.put("13", "13 - Create employee");
        menu.put("14", "14 - Delete employee by ID");
        menu.put("15", "15 - Update employee by ID");

        menu.put("21", "21 - Get all equipment locations");
        menu.put("22", "22 - Get equipment location by ID");
        menu.put("23", "23 - Create equipment location");
        menu.put("24", "24 - Delete equipment location by ID");
        menu.put("25", "25 - Update equipment location by ID");

        menu.put("31", "31 - Get all initiating employees");
        menu.put("32", "32 - Get initiating employee by id");
        menu.put("33", "33 - Create initiating employee");
        menu.put("34", "34 - Delete initiating employee by ID");
        menu.put("35", "35 - Update initiating employee");

        menu.put("41", "41 - Get all priorities");
        menu.put("42", "42 - Get priority by ID");
        menu.put("43", "43 - Create priority");
        menu.put("44", "44 - Delete priority by ID");
        menu.put("45", "45 - Update priority by ID");

        menu.put("51", "51 - Get all responsible employees");
        menu.put("52", "52 - Get responsible employee by ID");
        menu.put("53", "53 - Create responsible employee");
        menu.put("54", "54 - Delete responsible employee by ID");
        menu.put("55", "55 - Update responsible employee by ID");

        menu.put("61", "61 - Get all statements");
        menu.put("62", "62 - Get statement by ID");
        menu.put("63", "63 - Create statement");
        menu.put("64", "64 - Delete statement by ID");
        menu.put("65", "65 - Update statement by ID");

        menu.put("71", "71 - Get all statuses");
        menu.put("72", "72 - Get status by ID");
        menu.put("73", "73 - Create status");
        menu.put("74", "74 - Delete status by ID");
        menu.put("75", "75 - Update status by ID");

        menu.put("81", "81 - Get all types of statement");
        menu.put("82", "82 - Get type of statement by ID");
        menu.put("83", "83 - Create type of statement");
        menu.put("84", "84 - Delete type of statement by ID");
        menu.put("85", "85 - Update type of statement by ID");

        menu.put("91", "91 - Get all working positions of statement");
        menu.put("92", "92 - Get working position by ID");
        menu.put("93", "93 - Create working position");
        menu.put("94", "94 - Delete working position by ID");
        menu.put("95", "95 - Update working position by ID");



        methodsMenu.put("11", this::getAllEmployees);
        methodsMenu.put("12", this::getEmployeeById);
        methodsMenu.put("13", this::createEmployee);
        methodsMenu.put("14", this::deleteEmployeeById);
        methodsMenu.put("15", this::updateEmployeeById);

        methodsMenu.put("21", this::getAllEquipmentLocations);
        methodsMenu.put("22", this::getEquipmentLocationById);
        methodsMenu.put("23", this::createEquipmentLocation);
        methodsMenu.put("24", this::deleteEquipmentLocationById);
        methodsMenu.put("25", this::updateEquipmentLocationById);

        methodsMenu.put("31", this::getAllInitiatingEmployees);
        methodsMenu.put("32", this::getInitiatingEmployeeById);
        methodsMenu.put("33", this::createInitiatingEmployee);
        methodsMenu.put("34", this::deleteInitiatingEmployeeById);
        methodsMenu.put("35", this::updateInitiatingEmployeeById);

        methodsMenu.put("41", this::getAllPriorities);
        methodsMenu.put("42", this::getPriorityById);
        methodsMenu.put("43", this::createPriority);
        methodsMenu.put("44", this::deletePriorityById);
        methodsMenu.put("45", this::updatePriorityById);

        methodsMenu.put("51", this::getAllResponsibleEmployees);
        methodsMenu.put("52", this::getResponsibleEmployeeById);
        methodsMenu.put("53", this::createResponsibleEmployee);
        methodsMenu.put("54", this::deleteResponsibleEmployeeById);
        methodsMenu.put("55", this::updateResponsibleEmployeeById);

        methodsMenu.put("61", this::getAllStatements);
        methodsMenu.put("62", this::getStatementById);
        methodsMenu.put("63", this::createStatement);
        methodsMenu.put("64", this::deleteStatementById);
        methodsMenu.put("65", this::updateStatementById);

        methodsMenu.put("71", this::getAllStatuses);
        methodsMenu.put("72", this::getStatusById);
        methodsMenu.put("73", this::createStatus);
        methodsMenu.put("74", this::deleteStatusById);
        methodsMenu.put("75", this::updateStatusById);

        methodsMenu.put("81", this::getAllTypesOfStatement);
        methodsMenu.put("82", this::getTypeOfStatementById);
        methodsMenu.put("83", this::createTypeOfStatement);
        methodsMenu.put("84", this::deleteTypeOfStatementById);
        methodsMenu.put("85", this::updateTypeOfStatementById);

        methodsMenu.put("91", this::getAllWorkingPositions);
        methodsMenu.put("92", this::getWorkingPositionById);
        methodsMenu.put("93", this::createWorkingPosition);
        methodsMenu.put("94", this::deleteWorkingPositionById);
        methodsMenu.put("95", this::updateWorkingPositionById);
    }



    private void getAllEmployees() throws SQLException {
        System.out.println("\nTable: employee");
        employeeController.getAll();
    }
    private void getEmployeeById() throws SQLException {
        System.out.println("Enter ID for Employee: ");
        int id = input.nextInt();
        input.nextLine();
        employeeController.getById(id);
    }
    private void createEmployee() throws SQLException {
        System.out.println("Enter new employee name: ");
        String name = input.nextLine();
        System.out.println("Enter new employee surname: ");
        String surname = input.nextLine();
        System.out.println("Enter new employee workingPositionId: ");
        int workingPositionId = input.nextInt();
        input.nextLine();
        Employee entity = new Employee(0, name, surname, workingPositionId);
        employeeController.create(entity);
    }
    private void deleteEmployeeById() throws SQLException {
        System.out.println("Enter ID to delete Employee: ");
        int id = input.nextInt();
        input.nextLine();
        employeeController.delete(id);
    }
    private void updateEmployeeById() throws SQLException {
        System.out.println("Enter employee id to update: ");
        int id = input.nextInt();
        input.nextLine();
        Employee oldEmployee = employeeController.getService().getById(id);
        System.out.println("Enter new name for employee: ");
        String name = input.nextLine();
        System.out.println("Enter new surname for employee: ");
        String surname = input.nextLine();
        System.out.println("Enter new working position id for employee: ");
        int workingPositionId = input.nextInt();
        input.nextLine();

        String newName = name;
        String newSurame = surname;
        Integer newWorkingPositionId = workingPositionId;

        if (name.equals("")) newName = oldEmployee.getName();
        if (surname.equals("")) newSurame = oldEmployee.getSurname();
        if (workingPositionId < 0) newWorkingPositionId = oldEmployee.getWorkingPositionId();

        Employee entity = new Employee(id, newName, newSurame, newWorkingPositionId);
        employeeController.update(entity);
    }

    private void getAllEquipmentLocations() throws SQLException {
        System.out.println("\nTable: equipment_location");
        equipmentLocationController.getAll();
    }
    private void getEquipmentLocationById() throws SQLException {
        System.out.println("Enter ID for Equipment Location: ");
        int id = input.nextInt();
        input.nextLine();
        equipmentLocationController.getById(id);
    }
    private void createEquipmentLocation() throws SQLException {
        System.out.println("Enter new office: ");
        String office = input.nextLine();
        System.out.println("Input new room number: ");
        Integer roomNumber = input.nextInt();
        System.out.println("Enter new working place number: ");
        Integer workingPositionId = input.nextInt();
        input.nextLine();
        EquipmentLocation entity = new EquipmentLocation(0, office, roomNumber, workingPositionId);
        equipmentLocationController.create(entity);
    }
    private void deleteEquipmentLocationById() throws SQLException {
        System.out.println("Enter ID to delete Equipment Location: ");
        int id = input.nextInt();
        input.nextLine();
        equipmentLocationController.delete(id);
    }
    private void updateEquipmentLocationById() throws SQLException {
        System.out.println("Enter Equipment Location id to update: ");
        int id = input.nextInt();
        input.nextLine();
        EquipmentLocation oldEquipmentLocation = equipmentLocationController.getService().getById(id);
        System.out.println("Enter new office: ");
        String office = input.nextLine();
        System.out.println("Enter new room number: ");
        int roomNumber = input.nextInt();
        System.out.println("Enter new working place number: ");
        int workingPlaceNumber = input.nextInt();
        input.nextLine();

        String newOffice = office;
        Integer newRoomNumber = roomNumber;
        Integer newWorkingPlaceNumber = workingPlaceNumber;

        if (office.equals("")) newOffice = oldEquipmentLocation.getOffice();
        if (roomNumber < 0) newRoomNumber = oldEquipmentLocation.getRoomNumber();
        if (workingPlaceNumber < 0) newWorkingPlaceNumber = oldEquipmentLocation.getWorkingPlaceNumber();

        EquipmentLocation entity = new EquipmentLocation(id, newOffice, newRoomNumber, newWorkingPlaceNumber);
        equipmentLocationController.update(entity);
    }

    private void getAllInitiatingEmployees() throws SQLException {
        System.out.println("\nTable: Initiating_employee");
        initiatingEmployeeController.getAll();
    }
    private void getInitiatingEmployeeById() throws SQLException {
        System.out.println("Enter ID for Initiating Employee: ");
        int id = input.nextInt();
        input.nextLine();
        initiatingEmployeeController.getById(id);
    }
    private void createInitiatingEmployee() throws SQLException {
        System.out.println("Enter new employee ID: ");
        Integer employeeId = input.nextInt();
        input.nextLine();
        InitiatingEmployee entity = new InitiatingEmployee(0, employeeId);
        initiatingEmployeeController.create(entity);
    }
    private void deleteInitiatingEmployeeById() throws SQLException {
        System.out.println("Enter ID to delete Initiating Employee: ");
        int id = input.nextInt();
        input.nextLine();
        initiatingEmployeeController.delete(id);
    }
    private void updateInitiatingEmployeeById() throws SQLException {
        System.out.println("Enter Initiating Employee id to update: ");
        int id = input.nextInt();
        input.nextLine();
        InitiatingEmployee oldInitiatingEmployee = initiatingEmployeeController.getService().getById(id);
        System.out.println("Enter new employee id: ");
        int employeeId = input.nextInt();
        input.nextLine();

        Integer newEmployeeId = employeeId;
        if (employeeId < 0) newEmployeeId = oldInitiatingEmployee.getEmployeeId();

        InitiatingEmployee entity = new InitiatingEmployee(id, newEmployeeId);
        initiatingEmployeeController.update(entity);
    }

    private void getAllPriorities() throws SQLException {
        System.out.println("\nTable: priority");
        priorityController.getAll();
    }
    private void getPriorityById() throws SQLException {
        System.out.println("Enter ID for priority: ");
        int id = input.nextInt();
        input.nextLine();
        priorityController.getById(id);
    }
    private void createPriority() throws SQLException {
        System.out.println("Enter new level: ");
        String level = input.nextLine();
        input.nextLine();
        Priority entity = new Priority(0, level);
        priorityController.create(entity);
    }
    private void deletePriorityById() throws SQLException {
        System.out.println("Enter ID to delete Priority: ");
        int id = input.nextInt();
        input.nextLine();
        initiatingEmployeeController.delete(id);
    }
    private void updatePriorityById() throws SQLException {
        System.out.println("Enter priority id to update: ");
        int id = input.nextInt();
        input.nextLine();
        Priority oldPriority = priorityController.getService().getById(id);
        System.out.println("Enter new level: ");
        String level = input.nextLine();
        input.nextLine();

        String newLevel = level;
        if (level.equals("")) newLevel = oldPriority.getLevel();

        Priority entity = new Priority(id, newLevel);
        priorityController.update(entity);
    }

    private void getAllResponsibleEmployees() throws SQLException {
        System.out.println("\nTable: responsible_employee");
        responsibleEmployeeController.getAll();
    }
    private void getResponsibleEmployeeById() throws SQLException {
        System.out.println("Enter ID for responsible employee: ");
        int id = input.nextInt();
        input.nextLine();
        responsibleEmployeeController.getById(id);
    }
    private void createResponsibleEmployee() throws SQLException {
        System.out.println("Enter new employee ID: ");
        Integer employeeId = input.nextInt();
        input.nextLine();
        ResponsibleEmployee entity = new ResponsibleEmployee(0, employeeId);
        responsibleEmployeeController.create(entity);
    }
    private void deleteResponsibleEmployeeById() throws SQLException {
        System.out.println("Enter ID to delete responsible employee: ");
        int id = input.nextInt();
        input.nextLine();
        responsibleEmployeeController.delete(id);
    }
    private void updateResponsibleEmployeeById() throws SQLException {
        System.out.println("Enter responsible employee id to update: ");
        int id = input.nextInt();
        input.nextLine();
        ResponsibleEmployee oldResponsibleEmployee = responsibleEmployeeController.getService().getById(id);
        System.out.println("Enter new employee id: ");
        int employeeId = input.nextInt();
        input.nextLine();

        Integer newEmployeeId = employeeId;
        if (employeeId < 0) newEmployeeId = oldResponsibleEmployee.getEmployeeId();

        ResponsibleEmployee entity = new ResponsibleEmployee(id, newEmployeeId);
        responsibleEmployeeController.update(entity);
    }

    private void getAllStatements() throws SQLException {
        System.out.println("\nTable: statement");
        statementController.getAll();
    }
    private void getStatementById() throws SQLException {
        System.out.println("Enter ID for Statement: ");
        int id = input.nextInt();
        input.nextLine();
        statementController.getById(id);
    }
    private void createStatement() throws SQLException {

        System.out.println("Enter new statement description: ");
        String description = input.nextLine();
        System.out.println("Enter new statement initiating employee id: ");
        Integer initiatingEmployeeId = input.nextInt();
        System.out.println("Enter new statement equipment location id: ");
        Integer equipmentLocationId = input.nextInt();
        System.out.println("Enter new statement status id: ");
        Integer statusId = input.nextInt();
        System.out.println("Enter new statement priority id: ");
        Integer priorityId = input.nextInt();
        System.out.println("Enter new statement responsible employee: ");
        Integer responsibleEmployeeId = input.nextInt();
        System.out.println("Enter new statement type of statement: ");
        Integer typeOfStatementId = input.nextInt();

        input.nextLine();

        Statement entity = new Statement(0, description, initiatingEmployeeId, equipmentLocationId, statusId,
                priorityId, responsibleEmployeeId, typeOfStatementId);
        statementController.create(entity);
    }
    private void deleteStatementById() throws SQLException {
        System.out.println("Enter ID to delete statement: ");
        int id = input.nextInt();
        input.nextLine();
        statementController.delete(id);
    }
    private void updateStatementById() throws SQLException {
        System.out.println("Enter statement id to update: ");
        int id = input.nextInt();
        input.nextLine();
        Statement oldStatement = statementController.getService().getById(id);
        System.out.println("Enter new description id: ");
        String description = input.nextLine();
        System.out.println("Enter new initiating employee id: ");
        int initiatingEmployeeId = input.nextInt();
        System.out.println("Enter new equipment location id");
        int equipmentLocationId = input.nextInt();
        System.out.println("Enter new status id");
        int statusId = input.nextInt();
        System.out.println("Enter new priority id");
        int priorityId = input.nextInt();
        System.out.println("Enter new responsible employee id");
        int responsibleEmployeeId = input.nextInt();
        System.out.println("Enter new type of statement id");
        int typeOfStatementId = input.nextInt();
        input.nextLine();

        String newDescription = description;
        int newInitiatingEmployeeId = initiatingEmployeeId;
        int newEquipmentLocationId = equipmentLocationId;
        int newStatusId = statusId;
        int newPriorityId = priorityId;
        int newResponsibleEmployeeId = responsibleEmployeeId;
        int newTypeOfStatementId = typeOfStatementId;

        if (newDescription.equals("")) newDescription = oldStatement.getDescription();
        if (newInitiatingEmployeeId < 0) newInitiatingEmployeeId = oldStatement.getEquipmentLocationId();
        if (newEquipmentLocationId < 0) newEquipmentLocationId = oldStatement.getEquipmentLocationId();
        if (newStatusId < 0) newStatusId = oldStatement.getStatusId();
        if (newPriorityId < 0) newPriorityId = oldStatement.getPriorityId();
        if (newResponsibleEmployeeId < 0) newResponsibleEmployeeId = oldStatement.getResponsibleEmployeeId();
        if (newTypeOfStatementId < 0) newTypeOfStatementId = oldStatement.getTypeOfStatementId();


        Statement entity = new Statement(id, newDescription, newInitiatingEmployeeId, newEquipmentLocationId,
                newStatusId, newPriorityId, newResponsibleEmployeeId, newTypeOfStatementId);
        statementController.update(entity);
    }

    private void getAllStatuses() throws SQLException {
        System.out.println("\nTable: status");
        statusController.getAll();
    }
    private void getStatusById() throws SQLException {
        System.out.println("Enter ID for status: ");
        int id = input.nextInt();
        input.nextLine();
        statusController.getById(id);
    }
    private void createStatus() throws SQLException {
        System.out.println("Enter new name: ");
        String name = input.nextLine();
        input.nextLine();
        Status entity = new Status(0, name);
        statusController.create(entity);
    }
    private void deleteStatusById() throws SQLException {
        System.out.println("Enter ID to delete status: ");
        int id = input.nextInt();
        input.nextLine();
        statusController.delete(id);
    }
    private void updateStatusById() throws SQLException {
        System.out.println("Enter status id to update: ");
        int id = input.nextInt();
        input.nextLine();
        Status oldStatus = statusController.getService().getById(id);
        System.out.println("Enter new name: ");
        String name = input.nextLine();
        input.nextLine();

        String newName = name;
        if (name.equals("")) newName = oldStatus.getName();

        Status entity = new Status(id, newName);
        statusController.update(entity);
    }

    private void getAllTypesOfStatement() throws SQLException {
        System.out.println("\nTable: type_of_statement");
        typeOfStatementController.getAll();
    }
    private void getTypeOfStatementById() throws SQLException {
        System.out.println("Enter ID for typeOfStatement: ");
        int id = input.nextInt();
        input.nextLine();
        typeOfStatementController.getById(id);
    }
    private void createTypeOfStatement() throws SQLException {
        System.out.println("Enter new name: ");
        String name = input.nextLine();
        input.nextLine();
        TypeOfStatement entity = new TypeOfStatement(0, name);
        typeOfStatementController.create(entity);
    }
    private void deleteTypeOfStatementById() throws SQLException {
        System.out.println("Enter ID to delete type of statement: ");
        int id = input.nextInt();
        input.nextLine();
        typeOfStatementController.delete(id);
    }
    private void updateTypeOfStatementById() throws SQLException {
        System.out.println("Enter type of statement id to update: ");
        int id = input.nextInt();
        input.nextLine();
        TypeOfStatement oldTypeOfStatement = typeOfStatementController.getService().getById(id);
        System.out.println("Enter new name: ");
        String name = input.nextLine();
        input.nextLine();

        String newName = name;
        if (name.equals("")) newName = oldTypeOfStatement.getName();

        TypeOfStatement entity = new TypeOfStatement(id, newName);
        typeOfStatementController.update(entity);
    }

    private void getAllWorkingPositions() throws SQLException {
        System.out.println("\nTable: working position");
        workingPositionController.getAll();
    }
    private void getWorkingPositionById() throws SQLException {
        System.out.println("Enter ID for working position: ");
        int id = input.nextInt();
        input.nextLine();
        workingPositionController.getById(id);
    }
    private void createWorkingPosition() throws SQLException {
        System.out.println("Enter new name: ");
        String name = input.nextLine();
        input.nextLine();
        WorkingPosition entity = new WorkingPosition(0, name);
        workingPositionController.create(entity);
    }
    private void deleteWorkingPositionById() throws SQLException {
        System.out.println("Enter ID to delete working position: ");
        int id = input.nextInt();
        input.nextLine();
        workingPositionController.delete(id);
    }
    private void updateWorkingPositionById() throws SQLException {
        System.out.println("Enter working position id to update: ");
        int id = input.nextInt();
        input.nextLine();
        WorkingPosition oldWorkingPosition = workingPositionController.getService().getById(id);
        System.out.println("Enter new name: ");
        String name = input.nextLine();
        input.nextLine();

        String newName = name;
        if (name.equals("")) newName = oldWorkingPosition.getName();

        WorkingPosition entity = new WorkingPosition(id, newName);
        workingPositionController.update(entity);
    }



    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }
    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception ignored) {}
        } while (!keyMenu.equals("Q"));
    }
}
