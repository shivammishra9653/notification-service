package com.notification.dto.request;

import com.notification.util.Constraints;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateNotificationRequest {

    @NotNull(message = "channel is required")
    @Pattern(regexp = "EMAIL|SMS", message = "channel must be EMAIL or SMS")
    private String channel;

    @Size(max = Constraints.SUBJECT_MAX, message = "message too long")
    private String subject;

    @NotBlank(message = "message is required")
    @Size(max = Constraints.MESSAGE_MAX, message = "message too long")
    private String message;

    @Size(max = 320, message = "email length invalid")
    @Email(message = "invalid email format")
    private String email;

    @Pattern(regexp = "^[+]?\\d(7, 15)$", message = "invalid phone format")
    private String phone;
}
