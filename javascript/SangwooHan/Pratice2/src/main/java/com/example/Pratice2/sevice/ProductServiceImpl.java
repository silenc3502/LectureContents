package com.example.Pratice2.sevice;

import com.example.Pratice2.entity.Product;
import com.example.Pratice2.repository.ProductReopsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductReopsitory reopsitory;

    @Override
    public void register(Product product) {
        reopsitory.create(product);
    }

    @Override
    public List<Product> list() throws Exception {
        return reopsitory.list();
    }
}
