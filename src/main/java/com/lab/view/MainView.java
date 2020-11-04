package com.lab.view;

import com.lab.controller.implementation.*;
import com.lab.model.implementation.*;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {
    private static final Scanner INPUT = new Scanner(System.in);
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

    public MainView(Session session) {
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


        methodsMenu.put("11", () -> getAllEmployees(session));
        methodsMenu.put("12", () -> getEmployeeById(session));
        methodsMenu.put("13", () -> createEmployee(session));
        methodsMenu.put("14", () -> deleteEmployeeById(session));
        methodsMenu.put("15", () -> updateEmployeeById(session));

        methodsMenu.put("21", () -> getAllEquipmentLocations(session));
        methodsMenu.put("22", () -> getEquipmentLocationById(session));
        methodsMenu.put("23", () -> createEquipmentLocation(session));
        methodsMenu.put("24", () -> deleteEquipmentLocationById(session));
        methodsMenu.put("25", () -> updateEquipmentLocationById(session));

        methodsMenu.put("31", () -> getAllInitiatingEmployees(session));
        methodsMenu.put("32", () -> getInitiatingEmployeeById(session));
        methodsMenu.put("33", () -> createInitiatingEmployee(session));
        methodsMenu.put("34", () -> deleteInitiatingEmployeeById(session));
        methodsMenu.put("35", () -> updateInitiatingEmployeeById(session));

        methodsMenu.put("41", () -> getAllPriorities(session));
        methodsMenu.put("42", () -> getPriorityById(session));
        methodsMenu.put("43", () -> createPriority(session));
        methodsMenu.put("44", () -> deletePriorityById(session));
        methodsMenu.put("45", () -> updatePriorityById(session));

        methodsMenu.put("51", () -> getAllResponsibleEmployees(session));
        methodsMenu.put("52", () -> getResponsibleEmployeeById(session));
        methodsMenu.put("53", () -> createResponsibleEmployee(session));
        methodsMenu.put("54", () -> deleteResponsibleEmployeeById(session));
        methodsMenu.put("55", () -> updateResponsibleEmployeeById(session));

        methodsMenu.put("61", () -> getAllStatements(session));
        methodsMenu.put("62", () -> getStatementById(session));
        methodsMenu.put("63", () -> createStatement(session));
        methodsMenu.put("64", () -> deleteStatementById(session));
        methodsMenu.put("65", () -> updateStatementById(session));

        methodsMenu.put("71", () -> getAllStatuses(session));
        methodsMenu.put("72", () -> getStatusById(session));
        methodsMenu.put("73", () -> createStatus(session));
        methodsMenu.put("74", () -> deleteStatusById(session));
        methodsMenu.put("75", () -> updateStatusById(session));

        methodsMenu.put("81", () -> getAllTypesOfStatement(session));
        methodsMenu.put("82", () -> getTypeOfStatementById(session));
        methodsMenu.put("83", () -> createTypeOfStatement(session));
        methodsMenu.put("84", () -> deleteTypeOfStatementById(session));
        methodsMenu.put("85", () -> updateTypeOfStatementById(session));

        methodsMenu.put("91", () -> getAllWorkingPositions(session));
        methodsMenu.put("92", () -> getWorkingPositionById(session));
        methodsMenu.put("93", () -> createWorkingPosition(session));
        methodsMenu.put("94", () -> deleteWorkingPositionById(session));
        methodsMenu.put("95", () -> updateWorkingPositionById(session));
    }


    private void getAllEmployees(Session session) throws SQLException {
        System.out.println("\nTable: employee");
        employeeController.getAll(session);
    }

    private void getEmployeeById(Session session) throws SQLException {
        System.out.println("Enter ID for Employee: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        employeeController.getById(id, session);
    }

    private void createEmployee(Session session) throws SQLException {
        System.out.println("Enter new employee name: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new employee surname: ");
        String surname = INPUT.nextLine();
        System.out.println("Enter new employee workingPositionId: ");
        int workingPositionId = INPUT.nextInt();
        INPUT.nextLine();
        WorkingPosition workingPosition = workingPositionController.getService().getById(workingPositionId, session);
        Employee entity = new Employee(0, name, surname, workingPosition);
        employeeController.create(entity, session);
    }

    private void deleteEmployeeById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Employee: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        employeeController.delete(id, session);
    }

    private void updateEmployeeById(Session session) throws SQLException {
        System.out.println("Enter employee id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Employee oldEmployee = employeeController.getService().getById(id, session);
        System.out.println("Enter new name for employee: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new surname for employee: ");
        String surname = INPUT.nextLine();
        System.out.println("Enter new working position id for employee: ");
        int workingPositionId = INPUT.nextInt();
        INPUT.nextLine();

        String newName = name;
        String newSurame = surname;
        WorkingPosition newWorkingPosition = workingPositionController.getService().getById(workingPositionId, session);

        if (name.equals("")) newName = oldEmployee.getName();
        if (surname.equals("")) newSurame = oldEmployee.getSurname();

        Employee entity = new Employee();
        entity.setName(newName);
        entity.setSurname(newSurame);
        entity.setWorkingPositionByWorkingPositionId(newWorkingPosition);
        employeeController.update(entity, session);
    }

    private void getAllEquipmentLocations(Session session) throws SQLException {
        System.out.println("\nTable: equipment_location");
        equipmentLocationController.getAll(session);
    }

    private void getEquipmentLocationById(Session session) throws SQLException {
        System.out.println("Enter ID for Equipment Location: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        equipmentLocationController.getById(id, session);
    }

    private void createEquipmentLocation(Session session) throws SQLException {
        System.out.println("Enter new office: ");
        String office = INPUT.nextLine();
        System.out.println("Input new room number: ");
        Integer roomNumber = INPUT.nextInt();
        System.out.println("Enter new working place number: ");
        Integer workingPositionId = INPUT.nextInt();
        INPUT.nextLine();
        EquipmentLocation entity = new EquipmentLocation(0, office, roomNumber, workingPositionId);
        equipmentLocationController.create(entity, session);
    }

    private void deleteEquipmentLocationById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Equipment Location: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        equipmentLocationController.delete(id, session);
    }

    private void updateEquipmentLocationById(Session session) throws SQLException {
        System.out.println("Enter Equipment Location id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        EquipmentLocation oldEquipmentLocation = equipmentLocationController.getService().getById(id, session);
        System.out.println("Enter new office: ");
        String office = INPUT.nextLine();
        System.out.println("Enter new room number: ");
        int roomNumber = INPUT.nextInt();
        System.out.println("Enter new working place number: ");
        int workingPlaceNumber = INPUT.nextInt();
        INPUT.nextLine();

        String newOffice = office;
        Integer newRoomNumber = roomNumber;
        Integer newWorkingPlaceNumber = workingPlaceNumber;

        if (office.equals("")) newOffice = oldEquipmentLocation.getOffice();
        if (roomNumber < 0) newRoomNumber = oldEquipmentLocation.getRoomNumber();
        if (workingPlaceNumber < 0) newWorkingPlaceNumber = oldEquipmentLocation.getWorkingPlaceNumber();

        EquipmentLocation entity = new EquipmentLocation(id, newOffice, newRoomNumber, newWorkingPlaceNumber);
        equipmentLocationController.update(entity, session);
    }

    private void getAllInitiatingEmployees(Session session) throws SQLException {
        System.out.println("\nTable: Initiating_employee");
        initiatingEmployeeController.getAll(session);
    }

    private void getInitiatingEmployeeById(Session session) throws SQLException {
        System.out.println("Enter ID for Initiating Employee: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        initiatingEmployeeController.getById(id, session);
    }

    private void createInitiatingEmployee(Session session) throws SQLException {
        System.out.println("Enter new employee ID: ");
        Integer employeeId = INPUT.nextInt();
        INPUT.nextLine();
        Employee employee = employeeController.getService().getById(employeeId, session);
        InitiatingEmployee entity = new InitiatingEmployee(0, employee);
        initiatingEmployeeController.create(entity, session);
    }

    private void deleteInitiatingEmployeeById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Initiating Employee: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        initiatingEmployeeController.delete(id, session);
    }

    private void updateInitiatingEmployeeById(Session session) throws SQLException {
        System.out.println("Enter Initiating Employee id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        InitiatingEmployee oldInitiatingEmployee = initiatingEmployeeController.getService().getById(id, session);
        System.out.println("Enter new employee id: ");
        int employeeId = INPUT.nextInt();
        INPUT.nextLine();

        Employee employee = employeeController.getService().getById(employeeId, session);

        InitiatingEmployee entity = new InitiatingEmployee(id, employee);
        initiatingEmployeeController.update(entity, session);
    }

    private void getAllPriorities(Session session) throws SQLException {
        System.out.println("\nTable: priority");
        priorityController.getAll(session);
    }

    private void getPriorityById(Session session) throws SQLException {
        System.out.println("Enter ID for priority: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        priorityController.getById(id, session);
    }

    private void createPriority(Session session) throws SQLException {
        System.out.println("Enter new level: ");
        String level = INPUT.nextLine();
        Priority entity = new Priority(0, level);
        priorityController.create(entity, session);
    }

    private void deletePriorityById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Priority: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        priorityController.delete(id, session);
    }

    private void updatePriorityById(Session session) throws SQLException {
        System.out.println("Enter priority id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Priority oldPriority = priorityController.getService().getById(id, session);
        System.out.println("Enter new level: ");
        String level = INPUT.nextLine();

        String newLevel = level;
        if (level.equals("")) newLevel = oldPriority.getLevel();

        Priority entity = new Priority(id, newLevel);
        priorityController.update(entity, session);
    }

    private void getAllResponsibleEmployees(Session session) throws SQLException {
        System.out.println("\nTable: responsible_employee");
        responsibleEmployeeController.getAll(session);
    }

    private void getResponsibleEmployeeById(Session session) throws SQLException {
        System.out.println("Enter ID for responsible employee: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        responsibleEmployeeController.getById(id, session);
    }

    private void createResponsibleEmployee(Session session) throws SQLException {
        System.out.println("Enter new employee ID: ");
        Integer employeeId = INPUT.nextInt();
        INPUT.nextLine();
        Employee employee = employeeController.getService().getById(employeeId, session);
        ResponsibleEmployee entity = new ResponsibleEmployee(0, employee);
        responsibleEmployeeController.create(entity, session);
    }

    private void deleteResponsibleEmployeeById(Session session) throws SQLException {
        System.out.println("Enter ID to delete responsible employee: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        responsibleEmployeeController.delete(id, session);
    }

    private void updateResponsibleEmployeeById(Session session) throws SQLException {
        System.out.println("Enter responsible employee id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new employee id: ");
        int employeeId = INPUT.nextInt();
        INPUT.nextLine();

        Employee employee = employeeController.getService().getById(employeeId, session);

        ResponsibleEmployee entity = new ResponsibleEmployee(id, employee);
        responsibleEmployeeController.update(entity, session);
    }

    private void getAllStatements(Session session) throws SQLException {
        System.out.println("\nTable: statement");
        statementController.getAll(session);
    }

    private void getStatementById(Session session) throws SQLException {
        System.out.println("Enter ID for Statement: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        statementController.getById(id, session);
    }

    private void createStatement(Session session) throws SQLException {

        System.out.println("Enter new statement description: ");
        String description = INPUT.nextLine();
        System.out.println("Enter new statement initiating employee id: ");
        Integer initiatingEmployeeId = INPUT.nextInt();
        System.out.println("Enter new statement equipment location id: ");
        Integer equipmentLocationId = INPUT.nextInt();
        System.out.println("Enter new statement status id: ");
        Integer statusId = INPUT.nextInt();
        System.out.println("Enter new statement priority id: ");
        Integer priorityId = INPUT.nextInt();
        System.out.println("Enter new statement responsible employee: ");
        Integer responsibleEmployeeId = INPUT.nextInt();
        System.out.println("Enter new statement type of statement: ");
        Integer typeOfStatementId = INPUT.nextInt();

        INPUT.nextLine();

        InitiatingEmployee initiatingEmployee = initiatingEmployeeController.getService().getById(initiatingEmployeeId,
                session);
        EquipmentLocation equipmentLocation = equipmentLocationController.getService().getById(equipmentLocationId,
                session);
        Status status = statusController.getService().getById(statusId, session);
        Priority priority = priorityController.getService().getById(priorityId, session);
        ResponsibleEmployee responsibleEmployee = responsibleEmployeeController.getService().getById(responsibleEmployeeId,
                session);
        TypeOfStatement typeOfStatement = typeOfStatementController.getService().getById(typeOfStatementId, session);

        Statement entity = new Statement(0, description, initiatingEmployee, equipmentLocation, status,
                priority, responsibleEmployee, typeOfStatement);
        statementController.create(entity, session);
    }

    private void deleteStatementById(Session session) throws SQLException {
        System.out.println("Enter ID to delete statement: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        statementController.delete(id, session);
    }

    private void updateStatementById(Session session) throws SQLException {
        System.out.println("Enter statement id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Statement oldStatement = statementController.getService().getById(id, session);
        System.out.println("Enter new description id: ");
        String description = INPUT.nextLine();
        System.out.println("Enter new initiating employee id: ");
        int initiatingEmployeeId = INPUT.nextInt();
        System.out.println("Enter new equipment location id");
        int equipmentLocationId = INPUT.nextInt();
        System.out.println("Enter new status id");
        int statusId = INPUT.nextInt();
        System.out.println("Enter new priority id");
        int priorityId = INPUT.nextInt();
        System.out.println("Enter new responsible employee id");
        int responsibleEmployeeId = INPUT.nextInt();
        System.out.println("Enter new type of statement id");
        int typeOfStatementId = INPUT.nextInt();
        INPUT.nextLine();

        String newDescription = description;
        InitiatingEmployee newInitiatingEmployee = initiatingEmployeeController.getService().getById(
                initiatingEmployeeId, session);
        EquipmentLocation newEquipmentLocation = equipmentLocationController.getService().getById(equipmentLocationId,
                session);
        Status newStatus = statusController.getService().getById(statusId, session);
        Priority newPriority = priorityController.getService().getById(priorityId, session);
        ResponsibleEmployee newResponsibleEmployee =
                responsibleEmployeeController.getService().getById(responsibleEmployeeId, session);
        TypeOfStatement newTypeOfStatement = typeOfStatementController.getService().getById(typeOfStatementId, session);

        if (newDescription.equals("")) newDescription = oldStatement.getDescription();


        Statement entity = new Statement(id, newDescription, newInitiatingEmployee, newEquipmentLocation,
                newStatus, newPriority, newResponsibleEmployee, newTypeOfStatement);
        statementController.update(entity, session);
    }

    private void getAllStatuses(Session session) throws SQLException {
        System.out.println("\nTable: status");
        statusController.getAll(session);
    }

    private void getStatusById(Session session) throws SQLException {
        System.out.println("Enter ID for status: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        statusController.getById(id, session);
    }

    private void createStatus(Session session) throws SQLException {
        System.out.println("Enter new name: ");
        String name = INPUT.nextLine();
        Status entity = new Status(0, name);
        statusController.create(entity, session);
    }

    private void deleteStatusById(Session session) throws SQLException {
        System.out.println("Enter ID to delete status: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        statusController.delete(id, session);
    }

    private void updateStatusById(Session session) throws SQLException {
        System.out.println("Enter status id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Status oldStatus = statusController.getService().getById(id, session);
        System.out.println("Enter new name: ");
        String name = INPUT.nextLine();

        String newName = name;
        if (name.equals("")) newName = oldStatus.getName();

        Status entity = new Status(id, newName);
        statusController.update(entity, session);
    }

    private void getAllTypesOfStatement(Session session) throws SQLException {
        System.out.println("\nTable: type_of_statement");
        typeOfStatementController.getAll(session);
    }

    private void getTypeOfStatementById(Session session) throws SQLException {
        System.out.println("Enter ID for typeOfStatement: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        typeOfStatementController.getById(id, session);
    }

    private void createTypeOfStatement(Session session) throws SQLException {
        System.out.println("Enter new name: ");
        String name = INPUT.nextLine();
        TypeOfStatement entity = new TypeOfStatement(0, name);
        typeOfStatementController.create(entity, session);
    }

    private void deleteTypeOfStatementById(Session session) throws SQLException {
        System.out.println("Enter ID to delete type of statement: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        typeOfStatementController.delete(id, session);
    }

    private void updateTypeOfStatementById(Session session) throws SQLException {
        System.out.println("Enter type of statement id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        TypeOfStatement oldTypeOfStatement = typeOfStatementController.getService().getById(id, session);
        System.out.println("Enter new name: ");
        String name = INPUT.nextLine();

        String newName = name;
        if (name.equals("")) newName = oldTypeOfStatement.getName();

        TypeOfStatement entity = new TypeOfStatement(id, newName);
        typeOfStatementController.update(entity, session);
    }

    private void getAllWorkingPositions(Session session) throws SQLException {
        System.out.println("\nTable: working position");
        workingPositionController.getAll(session);
    }

    private void getWorkingPositionById(Session session) throws SQLException {
        System.out.println("Enter ID for working position: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        workingPositionController.getById(id, session);
    }

    private void createWorkingPosition(Session session) throws SQLException {
        System.out.println("Enter new name: ");
        String name = INPUT.nextLine();
        WorkingPosition entity = new WorkingPosition(0, name);
        workingPositionController.create(entity, session);
    }

    private void deleteWorkingPositionById(Session session) throws SQLException {
        System.out.println("Enter ID to delete working position: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        workingPositionController.delete(id, session);
    }

    private void updateWorkingPositionById(Session session) throws SQLException {
        System.out.println("Enter working position id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        WorkingPosition oldWorkingPosition = workingPositionController.getService().getById(id, session);
        System.out.println("Enter new name: ");
        String name = INPUT.nextLine();

        String newName = name;
        if (name.equals("")) newName = oldWorkingPosition.getName();

        WorkingPosition entity = new WorkingPosition(id, newName);
        workingPositionController.update(entity, session);
    }


    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public final void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = INPUT.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception ignored) {
            }
        } while (!keyMenu.equals("Q"));
    }
}


