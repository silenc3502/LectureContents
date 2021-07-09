package com.example.practice2.service;

import com.example.practice2.entity.Product;

import java.util.List;

public interface ProductService {

    public void register(Product product) throws Exception;
    public List<Product> lists() throws Exception;
}
