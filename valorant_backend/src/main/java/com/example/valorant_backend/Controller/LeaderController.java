package com.example.valorant_backend.Controller;

import com.example.valorant_backend.Model.Leader;
import com.example.valorant_backend.Model.Ranks;
import com.example.valorant_backend.Service.LeaderServiceInterface;
import com.example.valorant_backend.Service.RanksServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leader")
public class LeaderController {
    private LeaderServiceInterface leaderServiceInterface;

    public LeaderController(LeaderServiceInterface leaderServiceInterface) {
        this.leaderServiceInterface = leaderServiceInterface;
    }

    // construir o create leaders
    @PostMapping()
    public ResponseEntity<Leader> saveLeader(@RequestBody Leader leader){
        return new ResponseEntity<Leader>(leaderServiceInterface.saveLeader(leader), HttpStatus.CREATED);
    }

    //construir todos os leaders dentro da API
    @GetMapping
    public List<Leader> getAllLeader(){
        return leaderServiceInterface.getAllLeader();
    }

    //construir obter o leader pelo ID
    // exemplo http://localhost:8080/api/leader/2
    @GetMapping("{id}")
    public ResponseEntity<Leader> getLeaderById(@PathVariable(name = "id") long leaderId){
        return new ResponseEntity<Leader>(leaderServiceInterface.getLeaderById(leaderId), HttpStatus.OK);
    }

    //construir update aos leaders na api
    // exemplo http://localhost:8080/api/leader/2
    @PutMapping("{id}")
    public ResponseEntity<Leader> updateLeader(@PathVariable(name = "id") long id,
                                             @RequestBody Leader leader){
        return new ResponseEntity<Leader>(leaderServiceInterface.updateLeader(leader, id), HttpStatus.OK);
    }

    //apagar um dos leaders
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLeader(@PathVariable(name = "id") long id){
        //apaga o leader da db
        leaderServiceInterface.deleteLeader(id);

        return new ResponseEntity<String>("Leader deleted!", HttpStatus.OK);
    }
}
