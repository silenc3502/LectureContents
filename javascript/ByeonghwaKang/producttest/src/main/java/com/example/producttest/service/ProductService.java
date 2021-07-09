package com.example.producttest.service;

import com.example.producttest.entity.Product;

import java.util.List;

public interface ProductService {
    public void register(Product product);

    public List<Product> list() throws Exception;
}