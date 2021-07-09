package com.example.market.rapository;

import com.example.market.entity.Market;
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
    public void create(Market market){
        String query = "insert into market (username ,name, price, description) values (?,?,?,?)";

        jdbcTemplate.update(query,market.getUsername(),market.getName(), market.getPrice(), market.getDescription());
    }
    public List<Market> list() throws  Exception {

        // RowMapper를 통해 얻은 행을 하나씩 List에 집어넣으니
        // results엔 DB에서 얻어온 행 정보들이 들어있다.
        List<Market> results = jdbcTemplate.query(
                "select username, market_no, name, price, description, reg_date from market " +
                        "where market_no > 0 order by market_no asc",
                // Row: 행
                // 여러개의 Column(열)들이 행 1개에 포함되어 있음
                // 여러 열들을 얻어와서 행으로 맵핑하는 작업을 수행함
                new RowMapper<Market>() {
                    @SneakyThrows
                    @Override
                    public Market mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Market market = new Market();

                        market.setUsername(rs.getString("username"));
                        market.setProductNo(rs.getInt("market_no"));
                        market.setName(rs.getString("name"));
                        market.setPrice(rs.getInt("price"));
                        market.setDescription(rs.getString("description"));
                        // rs.getDate()는 DB에 있는 날자 정보를 얻어옴

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        market.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        //board.setRegDate(rs.getTimestamp("reg_date"));

                        return market;
                    }
                }
        );

        return results;
    }

    public Market read (Integer productNo) throws Exception {
        List<Market> results = jdbcTemplate.query(
                "select market_no, username, name, price, description, reg_date from market where market_no = ?",
                new RowMapper<Market>() {
                    @Override
                    public Market mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Market market = new Market();

                        market.setProductNo(rs.getInt("market_no"));
                        market.setUsername(rs.getString("username"));
                        market.setName(rs.getString("name"));
                        market.setPrice(rs.getInt("price"));
                        market.setDescription(rs.getString("description"));
                        market.setRegDate(rs.getDate("reg_date"));

                        return market;
                    }
                }, productNo);

        return results.isEmpty() ? null : results.get(0);
    }
    public  void delete(Integer productNo) throws Exception{
        String query = "delete from market where market_no = ?";

        jdbcTemplate.update(query,productNo);
    }

    public void update(Market market) throws  Exception{
        String query = "update market set name = ?, price = ?, description = ? where market_no = ?";
        // where market_no = ? 앞에오는 ?에는 ,부호를 생략해야 에러가 뜨질않는다. 왤까???

        jdbcTemplate.update(query, market.getName(), market.getPrice(), market.getDescription(), market.getProductNo());
    }
    }
