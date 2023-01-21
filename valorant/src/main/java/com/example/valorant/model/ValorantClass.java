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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
