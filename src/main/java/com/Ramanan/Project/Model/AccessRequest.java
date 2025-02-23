package com.Ramanan.Project.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "access_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "information_id")
    private Information information;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;
}

