package com.notification.config;


import com.notification.service.channel.EmailNotificationChannel;
import com.notification.service.channel.NotificationChannel;
import com.notification.service.channel.SmsNotificationChannel;
import com.notification.service.factory.NotificationChannelFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public EmailNotificationChannel emailNotificationChannel() {
        return new EmailNotificationChannel();
    }

    @Bean
    public SmsNotificationChannel smsNotificationChannel() {
        return new SmsNotificationChannel();
    }


    @Bean
    public NotificationChannelFactory notificationChannelFactory(
            EmailNotificationChannel emailNotification, SmsNotificationChannel smsNotification) {
        NotificationChannelFactory factory = new NotificationChannelFactory();
        factory.register("EMAIL", emailNotification);
        factory.register("SMS", smsNotification);
        return factory;
    }
}
