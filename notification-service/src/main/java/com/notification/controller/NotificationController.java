package com.notification.controller;

import com.notification.dto.request.CreateNotificationRequest;
import com.notification.dto.response.NotificationResponse;
import com.notification.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {
    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<NotificationResponse> create(@Valid @RequestBody CreateNotificationRequest request) {
        NotificationResponse response = service.createAndSend(request);
        URI location = URI.create("/api/v1/notifications/" + response.getId());
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationResponse> get(@PathVariable("id") String id) {
        NotificationResponse notificationResponse = service.get(new ObjectId(id));
        return ResponseEntity.ok(notificationResponse);
    }
}
