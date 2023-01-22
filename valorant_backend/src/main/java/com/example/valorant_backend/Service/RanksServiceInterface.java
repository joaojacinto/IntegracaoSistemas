package com.example.valorant_backend.Service;

import com.example.valorant_backend.Model.Ranks;

import java.util.List;

public interface RanksServiceInterface {
    Ranks saveRanks(Ranks ranks);

    List<Ranks> getAllRanks();

    Ranks getRankById(long id);

    Ranks updateRanks(Ranks ranks, long id);

    void deleteRanks(long id);

}
