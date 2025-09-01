package com.notification.dto.response;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;

import java.time.Instant;

@Data
@Builder
public class NotificationResponse {

    private ObjectId id;
    private String channel;
    private String subject;
    private String message;
    private String to;
    private String status; // QUEUED, SENT, FAILED
    private Instant createdAt;
    private Instant updatedAt;
}
