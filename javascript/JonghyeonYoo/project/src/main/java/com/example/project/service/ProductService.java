package com.example.project.service;

import com.example.project.entity.Product;

import java.util.List;

public interface ProductService {
    public void register(Product board) throws Exception;

    public List<Product> list() throws Exception;
}
