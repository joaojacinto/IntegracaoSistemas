package com.example.valorant_backend.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "Leader")
public class Leader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "displayName")
    private String displayName;
    @Column(name = "rating")
    private String rating;
    @Column(name = "tier")
    private String tier;
    @Column(name = "wins")
    private String wins;
}
