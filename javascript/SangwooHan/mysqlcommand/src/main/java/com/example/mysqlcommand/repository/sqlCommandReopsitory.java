package com.example.mysqlcommand.repository;

import com.example.mysqlcommand.entity.Command;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class sqlCommandReopsitory {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void create (Command command){

        String query ="insert into command (username, command, commandmean) values (?,?,?)";
        jdbcTemplate.update(query,command.getUsername(),command.getCommand(),command.getCommandmean());
    }
    public List<Command> list() throws  Exception{
        List<Command> results = jdbcTemplate.query(
                "select command_no, username,  command, commandmean, reg_date from command " +
                        "where command_no > 0 order by command_no asc",
                new RowMapper<Command>() {
                    @SneakyThrows
                    @Override
                    public Command mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Command command = new Command();

                        command.setBulletinNo(rs.getInt("command_no"));
                        command.setUsername(rs.getString("username"));
                        command.setCommand(rs.getString("command"));
                        command.setCommandmean(rs.getString("commandmean"));



                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        command.setRegdate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return command;
                    }
                }
        );

        return results;
    }
}