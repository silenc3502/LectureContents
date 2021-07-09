package com.example.quest.service;

import com.example.quest.eutity.Market;

import java.util.List;

public interface MarketService {
        public void register(Market market) throws Exception;

        public List<Market> list() throws Exception ;

}
