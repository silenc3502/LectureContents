package com.example.practice1.repository;

import com.example.practice1.entity.Product;
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

    public void create(Product product) throws Exception{

        String query = "insert into product (productName , productInfo, productPrice) values(?,?,?)";

        jdbcTemplate.update(query,product.getProductName(),product.getProductInfo(),product.getProductPrice());

    }
    public List<Product> lists() throws Exception {

        List<Product> results = jdbcTemplate.query(
                "select product_No,productName,productInfo,productPrice,reg_date from product " +
                        "where product_no > 0 order by product_no desc",

                new RowMapper<Product>() {
                    @SneakyThrows
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();

                        product.setProductNo(rs.getInt("product_no"));
                        product.setProductName(rs.getString("productName"));
                        product.setProductInfo(rs.getString("productInfo"));
                        product.setProductPrice(rs.getString("productPrice"));
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        product.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return product;
                    }
                }
        );

        return results;
    }

    public Product read(Integer productNo) throws Exception{
        List<Product> results = jdbcTemplate.query(
                "select * from product where product_no= ? "
                , new RowMapper<Product>() {
                    @SneakyThrows
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Product product = new Product();

                        product.setProductNo(rs.getInt("product_no"));
                        product.setProductName(rs.getString("productName"));
                        product.setProductPrice(rs.getString("productPrice"));
                        product.setProductInfo(rs.getString("productInfo"));
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        product.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return product;
                    }
                },productNo);
        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer productNo){
        String query = "delete from product where product_no = ?";

        jdbcTemplate.update(query,productNo);
    }





}
