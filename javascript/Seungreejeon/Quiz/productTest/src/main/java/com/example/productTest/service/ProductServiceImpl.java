package com.example.productTest.service;

import com.example.productTest.entity.Product;
import com.example.productTest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public void register(Product product) {
        repository.create(product);
    }

    @Override
    public List<Product> list() throws Exception {
        return repository.list();
    }
}