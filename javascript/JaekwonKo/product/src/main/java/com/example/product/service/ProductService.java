package com.example.product.service;

import com.example.product.entity.Product;

import java.util.List;

public interface ProductService {
    public void register(Product product) throws Exception;

    public List<Product> list() throws Exception;
}

