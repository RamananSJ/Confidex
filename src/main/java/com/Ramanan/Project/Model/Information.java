package com.Ramanan.Project.Model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "information")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @Enumerated(EnumType.STRING)
    private InformationType type;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;
}

