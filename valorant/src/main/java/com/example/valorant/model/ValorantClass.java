package com.example.valorant.model;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "Valorant")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValorantClass {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "ID")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "fileName")
    private String fileName;


}
