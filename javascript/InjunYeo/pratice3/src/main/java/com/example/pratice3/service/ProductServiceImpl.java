package com.example.pratice3.service;


import com.example.pratice3.entity.Product;
import com.example.pratice3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository repository;

    @Override
    public void register(Product product) throws Exception {
        repository.create(product);
    }

    @Override
    public List<Product> lists() throws Exception {
        return repository.lists();
    }
}
