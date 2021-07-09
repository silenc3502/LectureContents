package com.example.demo.repository;

import com.example.demo.entity.Product;
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

        String query = "insert into product (objname, price) values (?, ?)";

        // jdbcTemplate.update(): 이것을 통해 실제 DB상의 값을 갱신함
        // query: 구동시킬 DB의 쿼리
        // 나머지 3개: query에 있는 ?에 배치할 값들을 결정함
        jdbcTemplate.update(query, product.getObjname(),product.getPrice());
    }

    public List<Product> list() throws Exception {

        List<Product> results = jdbcTemplate.query(
                "select pro_no, objname, price from product " +
                        "where pro_no > 0 order by pro_no desc",

                new RowMapper<Product>() {
                    @SneakyThrows
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();


                        product.setPro_no(rs.getInt("pro_no"));
                        product.setObjname(rs.getString("objname"));
                        product.setPrice(rs.getString("price"));

                        return product;
                    }
                }
        );

        return results;
    }
}
