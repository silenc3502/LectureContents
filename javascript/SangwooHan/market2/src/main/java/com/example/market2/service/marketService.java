package com.example.market2.service;

import com.example.market2.entity.Login;
import com.example.market2.entity.Market;
import com.example.market2.entity.Signup;

import java.util.List;

public interface marketService {
    public void register(Market market);
    public List<Market> list() throws Exception;

    public  Market read(Integer productNo) throws  Exception;

    public void remove(Integer productNo) throws  Exception;

    public  void modify(Market market) throws  Exception;
    public void signup(Signup signup);
    public  int login(Login login);

    public boolean logincheck(Login login, Signup signup);

}
