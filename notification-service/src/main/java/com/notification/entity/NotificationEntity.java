package com.notification.entity;


import com.notification.entity.base.AuditableEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document("Notifications")
public class NotificationEntity extends AuditableEntity {
    @Indexed
    private String channel;
    private String subject;
    private String message;
    private String to;
    private String status;
}
