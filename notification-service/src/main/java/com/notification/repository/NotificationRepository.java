package com.notification.repository;

import com.notification.entity.NotificationEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<NotificationEntity, ObjectId> {
}
