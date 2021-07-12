package com.example.cholongtest.service;
import com.example.cholongtest.entity.Membership;

import java.util.List;

public interface MembershipService {
    public void register(Membership membership) throws Exception;

    public List<Membership> list() throws Exception;

    public void login(Membership membership) throws Exception;
}
