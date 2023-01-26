package com.example.valorant_backend.Controller;

import com.example.valorant_backend.Model.Ranks;
import com.example.valorant_backend.Service.RanksServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/ranks")
public class RanksController {

    private RanksServiceInterface ranksServiceInterface;

    @Autowired
    public RanksController(RanksServiceInterface ranksServiceInterface) {
        this.ranksServiceInterface = ranksServiceInterface;
    }

    // construir o create ranks
    @PostMapping()
    public ResponseEntity<Ranks> saveRanks(@RequestBody Ranks ranks){
        return new ResponseEntity<Ranks>(ranksServiceInterface.saveRanks(ranks), HttpStatus.CREATED);
    }


    //construir todos os ranks dentro da API
    @GetMapping
    public List<Ranks> getAllRanks(){
        return ranksServiceInterface.getAllRanks();
    }


    //construir obter o rank pelo ID
    // exemplo http://localhost:8080/api/ranks/2
    @GetMapping("{id}")
    public ResponseEntity<Ranks> getRanksById(@PathVariable(name = "id") long rankId){
        return new ResponseEntity<Ranks>(ranksServiceInterface.getRankById(rankId), HttpStatus.OK);
    }


    //construir update aos ranks na api
    // exemplo http://localhost:8080/api/ranks/2
    @PutMapping("{id}")
    public ResponseEntity<Ranks> updateRanks(@PathVariable(name = "id") long id,
                                             @RequestBody Ranks ranks){
        return new ResponseEntity<Ranks>(ranksServiceInterface.updateRanks(ranks, id), HttpStatus.OK);
    }


    //apagar um dos ranks
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRanks(@PathVariable(name = "id") long id){
        //apaga o rank da db
        ranksServiceInterface.deleteRanks(id);

        return new ResponseEntity<String>("Rank deleted!", HttpStatus.OK);
    }
}
