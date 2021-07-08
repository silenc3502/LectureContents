package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer {
    private int cus_no;
    private String id;
    private String password;
    private String name;
    private String birth;
    private String adress;
    private String phone;
    private String email;

}
