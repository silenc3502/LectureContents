package com.example.Exam.repository;

import com.example.Exam.entity.Usermarket;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class UsermarketRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Usermarket usermarket){
        String query = "insert into usermarket (name, productname, price ,description) values (?,?,?,?)";

        jdbcTemplate.update(query,usermarket.getName(), usermarket.getProductname(), usermarket.getPrice(), usermarket.getDescription());
    }
    public List<Usermarket> list() throws  Exception {

        // RowMapper를 통해 얻은 행을 하나씩 List에 집어넣으니
        // results엔 DB에서 얻어온 행 정보들이 들어있다.
        List<Usermarket> results = jdbcTemplate.query(
                "select usermarket_no, name, price, productname, description, reg_date from usermarket " +
                        "where usermarket_no > 0 order by usermarket_no desc",
                // Row: 행
                // 여러개의 Column(열)들이 행 1개에 포함되어 있음
                // 여러 열들을 얻어와서 행으로 맵핑하는 작업을 수행함
                new RowMapper<Usermarket>() {
                    @SneakyThrows
                    @Override
                    public Usermarket mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Usermarket usermarket = new Usermarket();

                        usermarket.setProductno(rs.getInt("productno;"));
                        usermarket.setProductname(rs.getString("productname"));
                        usermarket.setName(rs.getString("name"));
                        usermarket.setPrice(rs.getInt("price"));
                        usermarket.setDescription(rs.getString("description"));
                        // rs.getDate()는 DB에 있는 날자 정보를 얻어옴

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        usermarket.setReg_date(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        //board.setRegDate(rs.getTimestamp("reg_date"));

                        return usermarket;
                    }
                }
        );

        return results;
    }
}