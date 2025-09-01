package com.notification.service;

import com.notification.dto.request.CreateNotificationRequest;
import com.notification.dto.response.NotificationResponse;
import com.notification.entity.NotificationEntity;
import com.notification.exception.NotFoundException;
import com.notification.exception.ValidationException;
import com.notification.mapper.NotificationMapper;
import com.notification.repository.NotificationRepository;
import com.notification.service.channel.NotificationChannel;
import com.notification.service.factory.NotificationChannelFactory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository repository;
    private final NotificationChannelFactory channelFactory;

    public NotificationServiceImpl(NotificationRepository repository, NotificationChannelFactory channelFactory) {
        this.repository = repository;
        this.channelFactory = channelFactory;
    }
    @Override
    @Transactional
    public NotificationResponse createAndSend(CreateNotificationRequest request) {
        if("EMAIL".equals(request.getChannel()) && StringUtils.isEmpty(request.getEmail())) {
            throw new ValidationException("Email is required for EMAIL channel");
        }

        if("SMS".equals(request.getChannel()) && StringUtils.isEmpty(request.getPhone())) {
            throw new ValidationException("phone is required for SMS channel");
        }

        NotificationEntity entity = NotificationMapper.toNotificationEntity(request);
        entity = repository.save(entity);

        NotificationChannel channel = channelFactory.resolve(entity.getChannel());
        try{
            channel.send(entity);
            entity.setStatus("SENT");
        }catch (Exception ex) {
            entity.setStatus("FAILED");
        }
        entity = repository.save(entity);

        return NotificationMapper.toResponse(entity);
    }

    @Override
    public NotificationResponse get(ObjectId id) {
        NotificationEntity entity = repository.findById(id).orElseThrow(
                () -> new NotFoundException("Notification not found: " + id));
        return NotificationMapper.toResponse(entity);
    }
}
