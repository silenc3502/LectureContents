package com.example.assignment.service;

import com.example.assignment.entity.Product;

import java.util.List;

public interface ProductService {
    public void register(Product product);

    public List<Product> list() throws Exception;
}