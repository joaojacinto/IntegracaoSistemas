package com.example.valorant_backend.Repository;

import com.example.valorant_backend.Model.Ranks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RanksRepository extends JpaRepository<Ranks, Long> {

}
