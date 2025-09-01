package com.notification.service;

import com.notification.dto.request.CreateNotificationRequest;
import com.notification.dto.response.NotificationResponse;
import org.bson.types.ObjectId;

public interface NotificationService {

    NotificationResponse createAndSend(CreateNotificationRequest request);
    NotificationResponse get(ObjectId id);
}
