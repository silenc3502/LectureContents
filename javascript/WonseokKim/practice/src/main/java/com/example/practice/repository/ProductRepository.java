package com.example.practice.repository;

import com.example.practice.entity.Product;
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
public class ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Product product) {
        String query = "insert into product (title, content, writer) values (?, ?, ?)";

        jdbcTemplate.update(query, product.getTitle(), product.getContent(), product.getWriter());
    }

    public List<Product> list() throws Exception {
        // RowMapper를 통해 얻은 행을 하나씩 List에 집어넣으니
        // results엔 DB에서 얻어온 행 정보들이 들어있다.
        List<Product> results = jdbcTemplate.query(
                "select product_no, title, content, writer, reg_date from product " +
                        "where product_no > 0 order by product_no desc",
                // Row: 행
                // 여러개의 Column(열)들이 행 1개에 포함되어 있음
                // 여러 열들을 얻어와서 행으로 맵핑하는 작업을 수행함
                new RowMapper<Product>() {
                    @SneakyThrows
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();


                        product.setProductNo(rs.getInt("product_no"));
                        product.setTitle(rs.getString("title"));
                        product.setContent(rs.getString("content"));
                        product.setWriter(rs.getString("writer"));


                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


                        product.setRegDate(sdf.parse(rs.getDate("reg_date")
                                + " " + rs.getTime("reg_date")));

                        //System.out.println("rs.getDate(): " + rs.getTimestamp("reg_date"));
                        //System.out.println("rs.getDate(): " + rs.getDate("reg_date"));
                        //System.out.println("rs.getTime(): " + rs.getTime("reg_date"));

                        return product;
                    }
                }
        );

        return results;
    }
}

