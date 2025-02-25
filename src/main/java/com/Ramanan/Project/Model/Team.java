package com.Ramanan.Project.Model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teams")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false, columnDefinition = "int default 15")
    private int strength = 15;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;
}

