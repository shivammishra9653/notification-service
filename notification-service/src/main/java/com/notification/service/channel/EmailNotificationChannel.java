package com.notification.service.channel;

import com.notification.entity.NotificationEntity;

public class EmailNotificationChannel implements NotificationChannel {
    @Override
    public void send(NotificationEntity notification) {
        System.out.printf("[EMAIL] to=%s subject=%s\n", notification.getTo(), notification.getSubject());
    }

    @Override
    public String name() {
        return "EMAIL";
    }
}
