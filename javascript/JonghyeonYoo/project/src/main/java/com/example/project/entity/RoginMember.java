package com.example.project.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString

public class RoginMember {


        private String id;
        // th:field로 맵핑됨
        private String password;

        private Date regDate;
    }

