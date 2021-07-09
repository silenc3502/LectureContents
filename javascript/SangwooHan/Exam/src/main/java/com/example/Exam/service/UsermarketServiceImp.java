package com.example.Exam.service;

import com.example.Exam.entity.Usermarket;
import com.example.Exam.repository.UsermarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsermarketServiceImp  implements  UsermarketService{
 @Autowired
 private UsermarketRepository repository;
    @Override
    public void bomdong2(Usermarket usermarket) {
 repository.create(usermarket);
    }

    @Override
    public List<Usermarket> list() throws Exception {
        return repository.list();
    }
}
