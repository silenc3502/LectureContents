package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString

public class ArtworkPurchaseBoard {

    private int product_no;
    private int salePrice;
    private int rentalPrice;
    private String saleTitle;
    private String saleContent;
    private String saleWriter;
    private Date DrawingProductCreatedDate;

    // 크기(사이즈:가로, 세로, 높이 - 그림에는 가로, 세로만 입력 / 조형물에는 높이포함 입력하게하기)
    // 가능하다면 올린 그림의 색상구별? 아니면 작품등록시 애초에 색상을 입력하게 하기?
    // 판매가격과 렌탈가격을 따로만들기
    // 작성자에 대한 정보 땡겨오기(회원=작성자)
}

