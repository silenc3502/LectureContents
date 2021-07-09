package com.example.product.repository;

import com.example.product.entity.Product;
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

    //productname,productinfo,productprice
    public void create(Product product){
        String query ="insert into product (productname,productinfo,productprice ) values (?,?,?)";

        jdbcTemplate.update(query,product.getProductName(),product.getProductInfo(),product.getProductPrice());
    }

    public List<Product> list()  throws Exception{

        List<Product> results = jdbcTemplate.query(
                "select product_no,productname,productinfo,productprice,reg_date from product" +
                        "where product_no > 0 order by product_no desc", new RowMapper<Product>() {
                    @SneakyThrows
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Product product = new Product();

                        product.setProductNo(rs.getInt("product_no"));
                        product.setProductName(rs.getString("productname"));
                        product.setProductInfo(rs.getString("productInfo"));
                        product.setProductPrice(rs.getString("productprice"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        product.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));



                        return product;
                    }
                }
        );

    return results;
    }



}
