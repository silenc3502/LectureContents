package com.example.Project.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
public class Membership {
    private String name;
    private String user_id;
    private String password;
    private String address;
    private Date reg_date;
}
