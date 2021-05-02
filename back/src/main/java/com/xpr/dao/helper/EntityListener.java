package com.xpr.dao.helper;



import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.xpr.services.ContextWrapper;
import com.xpr.services.LogFactory;

import java.io.IOException;

public class EntityListener {


    public static LogFactory loggerFactory;

    @PreUpdate
    @PrePersist
    public void postCreate(XprBaseModel object) throws IOException {
        if (loggerFactory == null) {
            loggerFactory = ContextWrapper.getContext().getBean(LogFactory.class);
        }

        if (object.getSavedState() == null) {
            loggerFactory.createLog(LogFactory.CREATE, object);
        } else {
            loggerFactory.createLog(LogFactory.UPDATE, object);
        }
        
        
    }

//    @PostLoad
//    public void postLoad(MunisysBaseModel object) throws IOException {
//        if (loggerFactory == null) {
//            loggerFactory = ContextWrapper.getContext().getBean(LogFactory.class);
//        }
//
//        loggerFactory.createLog(LogFactory.READ, object);
//    }

    @PreRemove
    public void preRemove(XprBaseModel object) throws IOException {
        if (loggerFactory == null) {
            loggerFactory = ContextWrapper.getContext().getBean(LogFactory.class);
        }

        loggerFactory.createLog(LogFactory.DELETE, object);
    }
}
