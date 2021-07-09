package com.example.quest.repository;

import com.example.quest.eutity.Market;
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
public class MarketRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Market market) throws Exception {
        String query = "insert into market (ProductName, content, price) values (?, ?, ?)";

        jdbcTemplate.update(query, market.getProductName(), market.getContent(), market.getPrice());
    }

    public List<Market> list()throws Exception{
        // RowMapper를 통해 얻은 행을 하나씩 List에 집어넣으니
        // results엔 DB에서 얻어온 행 정보들이 들어있다.
        List<Market> results = jdbcTemplate.query(
                "select market_no, ProductName, content, price, reg_date from market " +
                        "where market_no > 0 order by market_no desc",
                new RowMapper<Market>() {
                    @SneakyThrows
                    @Override
                    public Market mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Market market = new Market();


                        market.setMarketNo(rs.getInt("market_no"));

                        market.setProductName(rs.getString("productName"));
                        market.setContent(rs.getString("content"));
                        market.setPrice(rs.getString("price"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        market.setRegDate(sdf.parse(rs.getTimestamp("reg_date") + " " + rs.getTime("reg_date")));




                        return market;
                    }
                }
        );

        return results;
    }
}