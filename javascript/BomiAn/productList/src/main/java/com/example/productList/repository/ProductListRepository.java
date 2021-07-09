package com.example.productList.repository;

import com.example.productList.entity.Product;
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
public class ProductListRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Product product) throws Exception{
        String query = "insert into product (product_name, content, writer) values (?, ?, ?)";

        jdbcTemplate.update(query, product.getProductName(), product.getContent(), product.getWriter());

    }

    public List<Product> list() throws Exception {
        List<Product> results = jdbcTemplate.query(
                "select product_no, product_name, content, writer, reg_date from product " +
                        "where product_no > 0 order by product_no desc",

                new RowMapper<Product>() {
                    @SneakyThrows
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();

                        // rs.getInt()는 DB에 있는 정수형 정보를 얻어옴
                        product.setProductNo(rs.getInt("product_no"));
                        // rs.getString()은 DB에 있는 문자열 정보를 얻어옴
                        product.setProductName(rs.getString("product_name"));
                        product.setContent(rs.getString("content"));
                        product.setWriter(rs.getString("writer"));
                        // rs.getDate()는 DB에 있는 날자 정보를 얻어옴
                        // board.setRegDate(rs.getDate("reg_date"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


                        product.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        //System.out.println("rs.getDate(): " + rs.getTimestamp("reg_date"));
                        //System.out.println("rs.getDate(): " + rs.getDate("reg_date"));
                        //System.out.println("rs.getTime(): " + rs.getTime("reg_date"));

                        return product;
                    }
                }
        );

        return results;
    }

    public Product read(Integer productNo) throws Exception {
        List<Product> results = jdbcTemplate.query(
                "select product_no, product_name, writer, content, reg_date from product where product_no = ?",
                new RowMapper<Product>() {
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();
                        product.setProductNo(rs.getInt("product_no"));
                        product.setProductName(rs.getString("product_name"));
                        product.setContent(rs.getString("content"));
                        product.setWriter(rs.getString("writer"));
                        product.setRegDate(rs.getDate("reg_date"));

                        return product;
                    }
                }, productNo);
        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer productNo) {
        String query = "delete from product where product_no = ?";

        jdbcTemplate.update(query, productNo);
    }

}
