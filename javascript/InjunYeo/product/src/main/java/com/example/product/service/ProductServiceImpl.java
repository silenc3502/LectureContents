package com.example.product.service;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    public void register(Product product){
        repository.create(product);
    }

    @Override
    public List<Product> list() throws Exception {
        return repository.list();
    }
}
