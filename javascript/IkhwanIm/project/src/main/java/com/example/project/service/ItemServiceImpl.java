package com.example.project.service;
import com.example.project.entity.Item;
import com.example.project.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository repository;

    @Override
    public void registerItem(Item item) throws Exception {
        repository.create(item);

    }

    @Override
    public List<Item> list() throws Exception {
        return repository.list();
    }

}
