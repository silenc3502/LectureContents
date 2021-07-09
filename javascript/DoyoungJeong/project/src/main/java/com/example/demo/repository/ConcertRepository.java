package com.example.demo.repository;

import com.example.demo.entity.Concert;
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
public class ConcertRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Concert concert) {
        String query = "insert into concertList (concertName, concertArtist, concertVenue, month, day, year, " +
                "price, concertInfo) values (?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, concert.getConcertName(), concert.getConcertArtist(), concert.getConcertVenue(),
                 concert.getMonth(), concert.getDay(), concert.getYear(), concert.getPrice(), concert.getConcertInfo());
    }

    public List<Concert> list() throws Exception {
        List<Concert> results = jdbcTemplate.query(
                "select concert_no, concertName, concertArtist, concertVenue, month, day, year, price, " +
                        "concertInfo, reg_date from concertList where concert_no > 0 order by concert_no asc",

                new RowMapper<Concert>() {
                    @SneakyThrows
                    @Override
                    public Concert mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Concert concert = new Concert();

                        concert.setConcertNo(rs.getInt("concert_no"));
                        concert.setConcertName(rs.getString("concertName"));
                        concert.setConcertArtist(rs.getString("concertArtist"));
                        concert.setConcertVenue(rs.getString("concertVenue"));
                        concert.setMonth(rs.getInt("month"));
                        concert.setDay(rs.getInt("day"));
                        concert.setYear(rs.getInt("year"));
                        concert.setPrice(rs.getInt("price"));
                        concert.setConcertInfo(rs.getString("concertInfo"));

                        concert.setConcertDate(rs.getString("month") + "-" + rs.getString("day") + "-" + rs.getString("year"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        concert.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return concert;
                    }

                }
        );
        return results;
    }
}