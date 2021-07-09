package com.example.demo.service;


import com.example.demo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public void join(Customer customer) throws Exception;

    public void login(Customer customer) throws Exception;

    public List<Customer> list() throws Exception;
}
