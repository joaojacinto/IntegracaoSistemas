package com.example.valorant_backend.Model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "RANKS")
public class Ranks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "TIERNAME", nullable = false)
    private String tierName;
    @Column(name = "ICONTIERFILE")
    private String iconTierFile;

}
