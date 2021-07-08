package com.example.project1.repository;

import com.example.project1.entity.Product;
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
        String query = "insert into product (name, price,weight, description) values (?, ?, ?, ?)";

        jdbcTemplate.update(query, product.getName(), product.getPrice(), product.getWeight(), product.getDescription());
    }

    public List<Product> list() throws Exception {
        List<Product> results = jdbcTemplate.query(
                "select product_no, name, price, weight, description, reg_date from product " +
                        "where product_no > 0 order by product_no desc",
                new RowMapper<Product>() {
                    @SneakyThrows
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();

                        product.setProductNo(rs.getInt("product_no"));
                        product.setName(rs.getString("name"));
                        product.setPrice(rs.getInt("price"));
                        product.setWeight(rs.getInt("weight"));
                        product.setDescription(rs.getString("description"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        product.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return product;
                    }
                }
        );

        return results;
    }
    public Product read (Integer productNo) throws Exception {
        List<Product> results = jdbcTemplate.query(
                "select product_no, name, price, weight, description, reg_date from product where product_no = ? " ,
                new RowMapper<Product>() {
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Product product = new Product();

                        product.setProductNo(rs.getInt("product_no"));
                        product.setName(rs.getString("name"));
                        product.setPrice(rs.getInt("price"));
                        product.setWeight(rs.getInt("weight"));
                        product.setDescription(rs.getString("description"));
                        product.setRegDate(rs.getDate("reg_date"));

                        return product;
                    }
                }, productNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer productNo) throws Exception{
        String query = "delete from product where product_no = ?";

        jdbcTemplate.update(query, productNo);

    }
    public void update(Product product) throws Exception{
        String query = "update product set name = ?, price = ?, weight = ? , description = ?where product_no = ?";

        jdbcTemplate.update(query, product.getName(), product.getPrice(),product.getWeight(),product.getDescription(), product.getProductNo());
    }
}