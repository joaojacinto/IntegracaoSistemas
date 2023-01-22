package com.example.valorant_backend.Service;

import com.example.valorant_backend.Exception.ResourceNotFoundException;
import com.example.valorant_backend.Model.Ranks;
import com.example.valorant_backend.Repository.RanksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RanksServiceInterfaceClass implements RanksServiceInterface {

    private RanksRepository ranksRepository;

    @Autowired
    public RanksServiceInterfaceClass(RanksRepository ranksRepository) {
        this.ranksRepository = ranksRepository;
    }

    @Override
    public Ranks saveRanks(Ranks ranks) {
        return ranksRepository.save(ranks);
    }

    @Override
    public List<Ranks> getAllRanks() {
        return ranksRepository.findAll();
    }

    @Override
    public Ranks getRankById(long id) {
        Optional<Ranks> ranks = ranksRepository.findById(id);

        if(ranks.isPresent()){
            return ranks.get();
        } else {
            throw new ResourceNotFoundException("Ranks","ID", id);
        }
    }

    @Override
    public Ranks updateRanks(Ranks ranks, long id) {
        //primeiro verificar se o id surge na db
        Ranks existentRank = ranksRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Rank", "Id", id));

        existentRank.setId(ranks.getId());
        existentRank.setTierName(ranks.getTierName());
        existentRank.setIconTierFile(ranks.getIconTierFile());

        //guardar os ranks na db
        ranksRepository.save(existentRank);

        return existentRank;
    }

    @Override
    public void deleteRanks(long id) {
        //confirmar se o id existe na db
        ranksRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ranks", "Id", id));

        ranksRepository.deleteById(id);
    }
}
