package com.example.project1.service;

import com.example.project1.entity.Product;

import java.util.List;

public interface ProductService {
    public void register(Product product);

    public List<Product> list() throws Exception;

    public Product read(Integer productNo) throws Exception;

    public void remove (Integer productNo) throws Exception;

    public void modify(Product product) throws Exception;
}