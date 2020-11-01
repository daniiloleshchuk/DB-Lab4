package com.lab.model.implementation;

import com.lab.model.GeneralModelInterface;

public class Statement implements GeneralModelInterface {
    private Integer id;
    private String description;
    private String creationDate;
    private Integer initiatingEmployeeId;
    private Integer equipmentLocationId;
    private Integer statusId;
    private Integer priorityId;
    private Integer responsibleEmployeeId;
    private Integer typeOfStatementId;

    public Statement(Integer id, String description, Integer initiatingEmployeeId, Integer equipmentLocationId,
                     Integer statusId,
                     Integer priorityId, Integer responsibleEmployeeId, Integer typeOfStatementId) {

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

    public Statement(Integer id, String description, String creationDate, Integer initiatingEmployeeId, Integer equipmentLocationId, Integer statusId, Integer priorityId, Integer responsibleEmployeeId, Integer typeOfStatementId) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getInitiatingEmployeeId() {
        return initiatingEmployeeId;
    }

    public void setInitiatingEmployeeId(Integer initiatingEmployeeId) {
        this.initiatingEmployeeId = initiatingEmployeeId;
    }

    public Integer getEquipmentLocationId() {
        return equipmentLocationId;
    }

    public void setEquipmentLocationId(Integer equipmentLocationId) {
        this.equipmentLocationId = equipmentLocationId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Integer priorityId) {
        this.priorityId = priorityId;
    }

    public Integer getResponsibleEmployeeId() {
        return responsibleEmployeeId;
    }

    public void setResponsibleEmployeeId(Integer responsibleEmployeeId) {
        this.responsibleEmployeeId = responsibleEmployeeId;
    }

    public Integer getTypeOfStatementId() {
        return typeOfStatementId;
    }

    public void setTypeOfStatementId(Integer typeOfStatementId) {
        this.typeOfStatementId = typeOfStatementId;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", initiatingEmployeeId=" + initiatingEmployeeId +
                ", equipmentLocationId=" + equipmentLocationId +
                ", statusId=" + statusId +
                ", priorityId=" + priorityId +
                ", responsibleEmployeeId=" + responsibleEmployeeId +
                ", typeOfStatementId=" + typeOfStatementId +
                '}';
    }
}

