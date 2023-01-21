package com.example.valorant.service;

import com.example.valorant.model.ValorantClass;
import com.example.valorant.repository.ValorantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValorantService {
    @Autowired
    private static ValorantRepository valorantRepository;

    public List<ValorantClass> listValorantClass(){
        return valorantRepository.findAll();
    }

    public static ValorantClass save(ValorantClass valorantClass){
        return valorantRepository.save(valorantClass);
    }
}
