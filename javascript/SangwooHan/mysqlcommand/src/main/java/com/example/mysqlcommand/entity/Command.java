package com.example.mysqlcommand.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Command {
    private int bulletinNo;
    private String username;
    private String command;
    private String commandmean;
    private Date regdate;

}
