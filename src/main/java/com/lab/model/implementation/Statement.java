package com.lab.model.implementation;

import com.lab.model.IGeneralModel;

public class Statement implements IGeneralModel {
    private Integer id;
    private String description;
    private String creationDate;
    private Integer initiatingEmployeeId;
    private Integer equipmentLocationId;
    private Integer statusId;
    private Integer priorityId;
    private Integer responsibleEmployeeId;
    private Integer typeOfStatementId;

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

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final String getDescription() {
        return description;
    }

    public final void setDescription(final String description) {
        this.description = description;
    }

    public final String getCreationDate() {
        return creationDate;
    }

    public final void setCreationDate(final String creationDate) {
        this.creationDate = creationDate;
    }

    public final Integer getInitiatingEmployeeId() {
        return initiatingEmployeeId;
    }

    public final void setInitiatingEmployeeId(final Integer initiatingEmployeeId) {
        this.initiatingEmployeeId = initiatingEmployeeId;
    }

    public final Integer getEquipmentLocationId() {
        return equipmentLocationId;
    }

    public final void setEquipmentLocationId(final Integer equipmentLocationId) {
        this.equipmentLocationId = equipmentLocationId;
    }

    public final Integer getStatusId() {
        return statusId;
    }

    public final void setStatusId(final Integer statusId) {
        this.statusId = statusId;
    }

    public final Integer getPriorityId() {
        return priorityId;
    }

    public final void setPriorityId(final Integer priorityId) {
        this.priorityId = priorityId;
    }

    public final Integer getResponsibleEmployeeId() {
        return responsibleEmployeeId;
    }

    public final void setResponsibleEmployeeId(final Integer responsibleEmployeeId) {
        this.responsibleEmployeeId = responsibleEmployeeId;
    }

    public final Integer getTypeOfStatementId() {
        return typeOfStatementId;
    }

    public final void setTypeOfStatementId(final Integer typeOfStatementId) {
        this.typeOfStatementId = typeOfStatementId;
    }

    @Override
    public final String toString() {
        return "Statement{"
                + "id=" + id
                + ", description='" + description + '\''
                + ", creationDate='" + creationDate + '\''
                + ", initiatingEmployeeId=" + initiatingEmployeeId
                + ", equipmentLocationId=" + equipmentLocationId
                + ", statusId=" + statusId
                + ", priorityId=" + priorityId
                + ", responsibleEmployeeId=" + responsibleEmployeeId
                + ", typeOfStatementId=" + typeOfStatementId
                + '}';
    }
}

