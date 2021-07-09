package com.example.practice2.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString

public class Product {

    private int productNo;
    private String productName;
    private String productInfo;
    private String productPrice;
    private Date regDate;

}
