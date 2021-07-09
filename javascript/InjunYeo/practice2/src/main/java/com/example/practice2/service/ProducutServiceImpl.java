package com.example.practice2.service;

import com.example.practice2.entity.Product;
import com.example.practice2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducutServiceImpl implements ProductService{
    @Autowired
    private ProductRepository repository;

    @Override
    public void register(Product product) throws Exception{
        repository.create(product);
    }

    @Override
    public List<Product> lists() throws Exception {
        return repository.lists();
    }
}
