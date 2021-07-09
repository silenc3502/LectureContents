package com.example.mysqlcommand.service;

import com.example.mysqlcommand.entity.Command;

import java.util.List;

public interface sqlcommandservice {
    public void register(Command command);

    public List<Command> list() throws  Exception;
}
