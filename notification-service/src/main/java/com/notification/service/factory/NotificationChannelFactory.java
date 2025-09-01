package com.notification.service.factory;

import com.notification.service.channel.NotificationChannel;

import java.util.HashMap;
import java.util.Map;

public class NotificationChannelFactory {
    private final Map<String, NotificationChannel> channels = new HashMap<>();
    public void register(String channel, NotificationChannel notificationChannel) {
        channels.put(channel, notificationChannel);
    }

    public NotificationChannel resolve(String name) {
        NotificationChannel channel = channels.get(name);
        if(channel ==  null) {
            throw new IllegalArgumentException("Unsupported channel: " + name);
        }
        return channel;
    }
}
