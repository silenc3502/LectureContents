package com.example.memberShipTest.eutity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.crypto.Data;


@Getter
@Setter
@ToString
public class Homework {
    private int homeworkNo;
    private String id;
    private String password;
    private Data regDate;
}
