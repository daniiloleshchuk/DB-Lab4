package com.lab.model.implementation;

import com.lab.model.IGeneralModel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Statement implements IGeneralModel {
    private static final String tableName = Statement.class.getSimpleName();
    private Integer id;
    private String description;
    private Timestamp creationDate;
    private InitiatingEmployee initiatingEmployeeByInitiatingEmployeeId;
    private EquipmentLocation equipmentLocationByEquipmentLocationId;
    private Status statusByStatusId;
    private Priority priorityByPriorityId;
    private ResponsibleEmployee responsibleEmployeeByResponsibleEmployeeId;
    private TypeOfStatement typeOfStatementByTypeOfStatementId;

    public Statement() {
        java.util.Date dt = new java.util.Date();
        this.creationDate = new Timestamp(dt.getTime());
    }

    public Statement(Integer id, String description, InitiatingEmployee initiatingEmployeeByInitiatingEmployeeId, EquipmentLocation equipmentLocationByEquipmentLocationId, Status statusByStatusId, Priority priorityByPriorityId, ResponsibleEmployee responsibleEmployeeByResponsibleEmployeeId, TypeOfStatement typeOfStatementByTypeOfStatementId) {
        this.id = id;
        this.description = description;
        java.util.Date dt = new java.util.Date();
        this.creationDate = new Timestamp(dt.getTime());
        this.initiatingEmployeeByInitiatingEmployeeId = initiatingEmployeeByInitiatingEmployeeId;
        this.equipmentLocationByEquipmentLocationId = equipmentLocationByEquipmentLocationId;
        this.statusByStatusId = statusByStatusId;
        this.priorityByPriorityId = priorityByPriorityId;
        this.responsibleEmployeeByResponsibleEmployeeId = responsibleEmployeeByResponsibleEmployeeId;
        this.typeOfStatementByTypeOfStatementId = typeOfStatementByTypeOfStatementId;
    }

    public Statement(Integer id, String description, Timestamp creationDate, InitiatingEmployee initiatingEmployeeByInitiatingEmployeeId, EquipmentLocation equipmentLocationByEquipmentLocationId, Status statusByStatusId, Priority priorityByPriorityId, ResponsibleEmployee responsibleEmployeeByResponsibleEmployeeId, TypeOfStatement typeOfStatementByTypeOfStatementId) {
        this.id = id;
        this.description = description;
        this.creationDate = creationDate;
        this.initiatingEmployeeByInitiatingEmployeeId = initiatingEmployeeByInitiatingEmployeeId;
        this.equipmentLocationByEquipmentLocationId = equipmentLocationByEquipmentLocationId;
        this.statusByStatusId = statusByStatusId;
        this.priorityByPriorityId = priorityByPriorityId;
        this.responsibleEmployeeByResponsibleEmployeeId = responsibleEmployeeByResponsibleEmployeeId;
        this.typeOfStatementByTypeOfStatementId = typeOfStatementByTypeOfStatementId;
    }
/*
    public Statement(final Integer id, final String description, final Integer initiatingEmployeeId,
                     final Integer equipmentLocationId, final Integer statusId, final Integer priorityId,
                     final Integer responsibleEmployeeId, final Integer typeOfStatementId) {

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        this.id = id;
        this.description = description;
        this.creationDate = sdf.format(dt);
        this.initiatingEmployeeId = initiatingEmployeeId;
        this.equipmentLocationId = equipmentLocationId;
        this.statusId = statusId;
        this.priorityId = priorityId;
        this.responsibleEmployeeId = responsibleEmployeeId;
        this.typeOfStatementId = typeOfStatementId;
    }


    public Statement(final Integer id, final String description, final String creationDate,
                     final Integer initiatingEmployeeId, final Integer equipmentLocationId, final Integer statusId,
                     final Integer priorityId, final Integer responsibleEmployeeId, final Integer typeOfStatementId) {
        this.id = id;
        this.description = description;
        this.creationDate = creationDate;
        this.initiatingEmployeeId = initiatingEmployeeId;
        this.equipmentLocationId = equipmentLocationId;
        this.statusId = statusId;
        this.priorityId = priorityId;
        this.responsibleEmployeeId = responsibleEmployeeId;
        this.typeOfStatementId = typeOfStatementId;
    }
     */

    public static String getTableName() {
        return tableName;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "creation_date")
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return Objects.equals(id, statement.id) &&
                Objects.equals(description, statement.description) &&
                Objects.equals(creationDate, statement.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, creationDate);
    }

    @ManyToOne
    @JoinColumn(name = "initiating_employee_id", referencedColumnName = "id", nullable = false)
    public InitiatingEmployee getInitiatingEmployeeByInitiatingEmployeeId() {
        return initiatingEmployeeByInitiatingEmployeeId;
    }

    public void setInitiatingEmployeeByInitiatingEmployeeId(InitiatingEmployee initiatingEmployeeByInitiatingEmployeeId) {
        this.initiatingEmployeeByInitiatingEmployeeId = initiatingEmployeeByInitiatingEmployeeId;
    }

    @ManyToOne
    @JoinColumn(name = "equipment_location_id", referencedColumnName = "id", nullable = false)
    public EquipmentLocation getEquipmentLocationByEquipmentLocationId() {
        return equipmentLocationByEquipmentLocationId;
    }

    public void setEquipmentLocationByEquipmentLocationId(EquipmentLocation equipmentLocationByEquipmentLocationId) {
        this.equipmentLocationByEquipmentLocationId = equipmentLocationByEquipmentLocationId;
    }

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    public Status getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(Status statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }

    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id", nullable = false)
    public Priority getPriorityByPriorityId() {
        return priorityByPriorityId;
    }

    public void setPriorityByPriorityId(Priority priorityByPriorityId) {
        this.priorityByPriorityId = priorityByPriorityId;
    }

    @ManyToOne
    @JoinColumn(name = "responsible_employee_id", referencedColumnName = "id", nullable = false)
    public ResponsibleEmployee getResponsibleEmployeeByResponsibleEmployeeId() {
        return responsibleEmployeeByResponsibleEmployeeId;
    }

    public void setResponsibleEmployeeByResponsibleEmployeeId(ResponsibleEmployee responsibleEmployeeByResponsibleEmployeeId) {
        this.responsibleEmployeeByResponsibleEmployeeId = responsibleEmployeeByResponsibleEmployeeId;
    }

    @ManyToOne
    @JoinColumn(name = "type_of_statement_id", referencedColumnName = "id", nullable = false)
    public TypeOfStatement getTypeOfStatementByTypeOfStatementId() {
        return typeOfStatementByTypeOfStatementId;
    }

    public void setTypeOfStatementByTypeOfStatementId(TypeOfStatement typeOfStatementByTypeOfStatementId) {
        this.typeOfStatementByTypeOfStatementId = typeOfStatementByTypeOfStatementId;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", initiatingEmployeeByInitiatingEmployeeId=" + initiatingEmployeeByInitiatingEmployeeId +
                ", equipmentLocationByEquipmentLocationId=" + equipmentLocationByEquipmentLocationId +
                ", statusByStatusId=" + statusByStatusId +
                ", priorityByPriorityId=" + priorityByPriorityId +
                ", responsibleEmployeeByResponsibleEmployeeId=" + responsibleEmployeeByResponsibleEmployeeId +
                ", typeOfStatementByTypeOfStatementId=" + typeOfStatementByTypeOfStatementId +
                '}';
    }
}
