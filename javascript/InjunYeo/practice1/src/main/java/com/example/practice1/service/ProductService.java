package com.example.practice1.service;

import com.example.practice1.entity.Product;

import java.util.List;

public interface ProductService {

    public void register(Product product) throws Exception;
    public List<Product> lists() throws Exception;
    public Product read(Integer productNo) throws Exception;
    public void remove(Integer prductNo) throws Exception;
}
