package com.example.valorant_backend.Service;

import com.example.valorant_backend.Exception.ResourceNotFoundException;
import com.example.valorant_backend.Model.Leader;
import com.example.valorant_backend.Model.Ranks;
import com.example.valorant_backend.Repository.LeaderRepository;
import com.example.valorant_backend.Repository.RanksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaderServiceInterfaceClass implements LeaderServiceInterface{
    private LeaderRepository leaderRepository;

    @Autowired
    public LeaderServiceInterfaceClass(LeaderRepository leaderRepository) {
        this.leaderRepository = leaderRepository;
    }

    @Override
    public Leader saveLeader(Leader leader) {
        return leaderRepository.save(leader);
    }

    @Override
    public List<Leader> getAllLeader() {
        return leaderRepository.findAll();
    }

    @Override
    public Leader getLeaderById(long id) {
        Optional<Leader> leader = leaderRepository.findById(id);

        if(leader.isPresent()){
            return leader.get();
        } else {
            throw new ResourceNotFoundException("Leader","ID", id);
        }
    }

    @Override
    public Leader updateLeader(Leader leader, long id) {
        //primeiro verificar se o id surge na db
        Leader existentLeader = leaderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Leader", "Id", id));

        existentLeader.setId(leader.getId());
        existentLeader.setDisplayName(leader.getDisplayName());
        existentLeader.setRating(leader.getRating());
        existentLeader.setTier(leader.getTier());
        existentLeader.setWins(leader.getWins());

        //guardar os leaders na db
        leaderRepository.save(existentLeader);

        return existentLeader;
    }

    @Override
    public void deleteLeader(long id) {
        //confirmar se o id existe na db
        leaderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Leader", "Id", id));

        leaderRepository.deleteById(id);
    }
}
