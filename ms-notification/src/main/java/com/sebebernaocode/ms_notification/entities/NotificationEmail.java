package com.sebebernaocode.ms_notification.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="tb_email")
public class NotificationEmail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emailId;

    private String fromName;
    @Email(regexp = "marchesaneduardofw@gmail.com", message = "Invalid e-mail format")
    private String fromEmail;
    private String toEmail;
    private String toName;
    private String cc;
    private String subject;
    private String body;
    private String contentType;
    private LocalDateTime sentDate;
    @Enumerated(EnumType.STRING)
    private Status status;
}
