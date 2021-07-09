package com.example.Pratice2.sevice;

import com.example.Pratice2.entity.Product;

import java.util.List;

public interface ProductService {

    public void register(Product product);

    public List<Product> list() throws Exception;
}
