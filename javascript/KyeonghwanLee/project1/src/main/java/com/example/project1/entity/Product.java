package com.example.project1.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Product {

    private int productNo;
    private String name;
    private int price;
    private int weight;
    private String description;
    private Date regDate;
}