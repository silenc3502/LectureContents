package com.example.demo.repository;


import com.example.demo.entity.Board;
import com.example.demo.entity.Customer;
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
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Customer customer) throws Exception {

        String query = "insert into customer (id, password, name, birth, adress, phone, email) values (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query,customer.getId(), customer.getPassword(), customer.getName(), customer.getBirth(), customer.getAdress(),
                customer.getPhone(),customer.getEmail());
    }
    public void login(Customer customer) throws Exception {

        List<Customer> results = jdbcTemplate.query(
                "select id, password from customer where id = ?",

                new RowMapper<Customer>() {
                    @Override
                    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Customer customer = new Customer();

                        customer.setId(rs.getString("id"));
                        customer.setPassword(rs.getString("password"));

                        return customer;
                    }
                }, customer.getId());

        Customer tmp = results.get(0);


        if (tmp.getPassword().equals(customer.getPassword())) {

        } else {

        }
    }
    public List<Customer> list() throws Exception {
        // RowMapper를 통해 얻은 행을 하나씩 List에 집어넣으니
        // results엔 DB에서 얻어온 행 정보들이 들어있다.
        List<Customer> results = jdbcTemplate.query(
                "select cus_no, id, password from customer " +
                        "where cus_no > 0 order by cus_no desc",
                // Row: 행
                // 여러개의 Column(열)들이 행 1개에 포함되어 있음
                // 여러 열들을 얻어와서 행으로 맵핑하는 작업을 수행함
                new RowMapper<Customer>() {
                    @SneakyThrows
                    @Override
                    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Customer customer = new Customer();

                        customer.setCus_no(rs.getInt("cus_no"));
                        customer.setId(rs.getString("id"));
                        customer.setPassword(rs.getString("password"));

                       // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                       // customer.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return customer;
                    }
                }
        );

        return results;
    }
}
