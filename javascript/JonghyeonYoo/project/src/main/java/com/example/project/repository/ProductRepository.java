package com.example.project.repository;

import com.example.project.entity.Product;
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

    public void create(Product product) throws Exception {
        String query = "insert into product (brandname, price, content, writer) values (?, ?, ?, ?)";
        jdbcTemplate.update(query, product.getBrandname(), product.getPrice(), product.getContent(), product.getWriter());
    }

    public List<Product> list() throws Exception {

        List<Product> results = jdbcTemplate.query(
                "select product_no, brandname, price, content, writer, reg_date from signup " +
                        "where product_no > 0 order by product_no desc",

                new RowMapper<Product>() {
                    @SneakyThrows
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();

                        product.setProductNo(rs.getInt("product_no"));
                        product.setBrandname(rs.getString("brandname"));
                        product.setPrice(rs.getString("price"));
                        product.setContent(rs.getString("content"));
                        product.setWriter(rs.getString("writer"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


                        product.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return product;
                    }
                }
        );

        return results;
    }
}