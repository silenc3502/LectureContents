package com.example.productList.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
public class Product {
    private int productNo;
    private String productName;
    private String content;
    private String writer;
    private Date regDate;

}
