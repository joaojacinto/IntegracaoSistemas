package com.example.valorant.repository;

import com.example.valorant.model.ValorantClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ValorantRepository extends JpaRepository<ValorantClass, UUID> {
    List<ValorantClass> findValorantClassBy(String expression);
}
