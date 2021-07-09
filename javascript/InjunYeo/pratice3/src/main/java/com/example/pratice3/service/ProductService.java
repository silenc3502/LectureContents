package com.example.pratice3.service;

import com.example.pratice3.entity.Product;

import java.util.List;

public interface ProductService {

    public void register(Product product) throws Exception;
    public List<Product> lists() throws Exception;
}
