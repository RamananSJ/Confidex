package com.Ramanan.Project.Model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "divisions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}

