package com.example.quest.eutity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Market {
    private int marketNo;
    private String productName;
    private String content;
    private String price;
    private Date regDate;


}
