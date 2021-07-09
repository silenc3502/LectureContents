package com.example.quest.service;

import com.example.quest.eutity.Market;
import com.example.quest.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarketServiceImpl implements MarketService {

    @Autowired
    private MarketRepository repository;

    @Override
    public void register(Market market) throws Exception {
        repository.create(market);
    }

    @Override
    public List<Market> list() throws Exception {

        return repository.list();
    }
}
