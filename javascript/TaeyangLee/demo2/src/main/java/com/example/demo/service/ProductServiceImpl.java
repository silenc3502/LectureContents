package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository repository;

    @Override
    public void register(Product product) throws Exception {
        repository.create(product);
    }

    @Override
    public List<Product> list() throws Exception {
        return repository.list();
    }
}
