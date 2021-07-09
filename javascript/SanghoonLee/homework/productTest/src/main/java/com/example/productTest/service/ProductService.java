package com.example.productTest.service;

import com.example.productTest.entity.Product;

import java.util.List;

public interface ProductService {
    public void register(Product product);

    public List<Product> list() throws Exception;
}
