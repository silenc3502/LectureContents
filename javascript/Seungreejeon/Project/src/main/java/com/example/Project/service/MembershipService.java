package com.example.Project.service;

import com.example.Project.entity.Membership;

import java.util.List;

public interface MembershipService {
    public void M_register(Membership membership) throws Exception;

    public List<Membership> list() throws Exception;

    public Membership read(Integer memberNo) throws Exception;

}
