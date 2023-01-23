package com.example.valorant_backend.Service;

import com.example.valorant_backend.Model.Leader;
import com.example.valorant_backend.Model.Ranks;

import java.util.List;

public interface LeaderServiceInterface {

    Leader saveLeader(Leader leader);

    List<Leader> getAllLeader();

    Leader getLeaderById(long id);

    Leader updateLeader(Leader leader, long id);

    void deleteLeader(long id);
}
