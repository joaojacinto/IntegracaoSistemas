package com.example.valorant.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "Ranks")
@Data
public class Ranks  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @UuidGenerator
    @Column(name = "ID")
    private long id;

    @Column(name = "tierName")
    private String tierName;

    @Column(name = "iconTierFile")
    private String iconTierFile;

    public Ranks(long id, String tierName, String iconTierFile) {
        this.id = id;
        this.tierName = tierName;
        this.iconTierFile = iconTierFile;
    }

    public Ranks() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTierName() {
        return tierName;
    }

    public void setTierName(String tierName) {
        this.tierName = tierName;
    }

    public String getIconTierFile() {
        return iconTierFile;
    }

    public void setIconTierFile(String iconTierFile) {
        this.iconTierFile = iconTierFile;
    }
}
