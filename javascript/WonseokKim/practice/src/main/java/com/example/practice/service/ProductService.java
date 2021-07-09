package com.example.practice.service;

import com.example.practice.entity.Product;

import org.springframework.stereotype.Service;
import java.util.List;

public interface ProductService {

    public void register(Product product);

    public List<Product> list() throws Exception;

}

