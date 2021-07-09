package com.example.sasuem.service;

import com.example.sasuem.entity.Stagbeetle;
import com.example.sasuem.rapository.insectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class insectdiagramserviceImps implements insectdiagramservice{
   @Autowired
   private insectRepository repository;
    @Override
    public void register(Stagbeetle stagbeetle) {
        repository.create(stagbeetle);
    }

    @Override
    public List<Stagbeetle> list() throws Exception {
        return repository.list();
    }
}
