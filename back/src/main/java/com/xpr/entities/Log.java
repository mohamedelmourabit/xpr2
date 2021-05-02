package com.xpr.entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.xpr.dao.core.view.ModelViews;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonView(ModelViews.SelectView.class)
    private Integer id;

    @JsonView(ModelViews.SelectView.class)
    private String action;

    @JsonView(ModelViews.SelectView.class)
    private String triggeredBy;

    @JsonView(ModelViews.SelectView.class)
    private String subject;

    @JsonView(ModelViews.SelectView.class)
    private String subjectId;

    @JsonView(ModelViews.SelectView.class)
    @Column(columnDefinition="TEXT")
    private String oldValue;

    @JsonView(ModelViews.SelectView.class)
    @Column(columnDefinition="TEXT")
    private String newValue;

    private Date incidentDate;

    private boolean archived;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTriggeredBy() {
        return triggeredBy;
    }

    public void setTriggeredBy(String triggeredBy) {
        this.triggeredBy = triggeredBy;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public Date getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
