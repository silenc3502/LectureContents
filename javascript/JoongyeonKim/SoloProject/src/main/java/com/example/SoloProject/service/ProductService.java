package com.example.SoloProject.service;

import com.example.SoloProject.entity.Product;

import java.util.List;

public interface ProductService {
    public void productregister(Product product);

    public List<Product> productlist() throws Exception;

    public Product productread(Integer productNo) throws Exception;

    public void productremove(Integer productNo) throws Exception;
}
