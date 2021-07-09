package com.example.Practice.domain;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Member {
    private long id;
    private String name;
    private int password;
    private String memberId;
    private Date date;
}
