package com.xpr.dao;


import java.util.Set;

import com.xpr.dao.helper.CustomJPARepository;
import com.xpr.entities.Notification;

public interface NotificationRepository extends CustomJPARepository<Notification, Integer> {
    Set<Notification> findByIsReadAndReceiver_Email(boolean isRead, String email);
}