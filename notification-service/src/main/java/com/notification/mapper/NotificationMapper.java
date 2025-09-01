package com.notification.mapper;

import com.notification.dto.request.CreateNotificationRequest;
import com.notification.dto.response.NotificationResponse;
import com.notification.entity.NotificationEntity;

public class NotificationMapper {
    private NotificationMapper(){}

    public static NotificationEntity toNotificationEntity(CreateNotificationRequest dto) {
        NotificationEntity entity = new NotificationEntity();
        entity.setChannel(dto.getChannel())
                .setSubject(dto.getSubject())
                .setMessage(dto.getMessage())
                .setTo(dto.getChannel().equals("EMAIL") ? dto.getEmail() : dto.getPhone())
                .setStatus("QUEUED");
        return entity;
    }

    public static NotificationResponse toResponse(NotificationEntity entity) {
        return NotificationResponse.builder()
                .id(entity.getId())
                .channel(entity.getChannel())
                .subject(entity.getSubject())
                .message(entity.getMessage())
                .to(entity.getTo())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
