package com.example.valorant.controller;

import com.example.valorant.model.ValorantClass;
import com.example.valorant.service.ValorantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/valorant")
public class ValorantController {
    private ValorantService valorantService;

    @Autowired
    public ValorantController(ValorantService valorantService) {
        this.valorantService = valorantService;
    }

    @GetMapping
    public ResponseEntity<List<ValorantClass>> listValorantClass(){
        return ResponseEntity.ok(valorantService.listValorantClass());
    }

    @PostMapping("/valorant")
    public ValorantClass createValorantClass(@RequestBody ValorantClass valorantClass) {
        return ValorantService.save(valorantClass);
    }
}
