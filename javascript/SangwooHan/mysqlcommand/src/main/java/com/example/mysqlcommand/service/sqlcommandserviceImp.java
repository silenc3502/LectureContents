package com.example.mysqlcommand.service;

import com.example.mysqlcommand.entity.Command;
import com.example.mysqlcommand.repository.sqlCommandReopsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sqlcommandserviceImp  implements sqlcommandservice{
    @Autowired
    private sqlCommandReopsitory reopsitory;
    @Override
    public void register(Command command) {
        reopsitory.create(command);
    }

    @Override
    public List<Command> list() throws Exception {
        return reopsitory.list();
    }
}
