package com.example.project.repository;

import com.example.project.entity.Item;
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
public class ItemRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Item item) throws Exception {
        String query = "insert into item (name, price, seller) values (?, ?, ?)";

        jdbcTemplate.update(query, item.getName(), item.getPrice(), item.getSeller());
    }

    public List<Item> list() throws Exception {
        List<Item> results = jdbcTemplate.query(
                "select item_no, name, price, seller, reg_date from item " +
                        "where item_no > 0 order by item_no desc",
                // Row: 행
                // 여러개의 Column(열)들이 행 1개에 포함되어 있음
                // 여러 열들을 얻어와서 행으로 맵핑하는 작업을 수행함
                new RowMapper<Item>() {
                    @SneakyThrows
                    @Override
                    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Item item = new Item();

                        item.setItemNo(rs.getInt("item_no"));
                        item.setName(rs.getString("name"));
                        item.setPrice(rs.getInt("price"));
                        item.setSeller(rs.getString("seller"));


                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


                        item.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        //System.out.println("rs.getDate(): " + rs.getTimestamp("reg_date"));
                        //System.out.println("rs.getDate(): " + rs.getDate("reg_date"));
                        //System.out.println("rs.getTime(): " + rs.getTime("reg_date"));

                        return item;
                    }
                }
        );

        return results;
    }
}