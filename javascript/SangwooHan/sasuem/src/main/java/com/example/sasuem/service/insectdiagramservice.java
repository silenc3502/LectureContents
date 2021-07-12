package com.example.sasuem.service;

import com.example.sasuem.entity.Stagbeetle;

import java.util.List;

public interface insectdiagramservice {
    public void register (Stagbeetle stagbeetle);

    public List<Stagbeetle> list() throws Exception;
}
