package com.notification.service.channel;

import com.notification.entity.NotificationEntity;

public interface NotificationChannel {

    void send(NotificationEntity notification);
    String name(); //EMAIL or SMS
}
