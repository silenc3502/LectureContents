package com.example.sasuem.rapository;

import com.example.sasuem.entity.Stagbeetle;
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
public class insectRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void create (Stagbeetle stagbeetle){

        String query ="insert into insect (username, insectname, old, habitat, description) values (?,?,?,?,?)";
        jdbcTemplate.update(query,stagbeetle.getUsername(),stagbeetle.getInsectname(),stagbeetle.getOld(),stagbeetle.getHabitat(),stagbeetle.getDescription());
    }
        public List<Stagbeetle> list() throws  Exception{
    List<Stagbeetle> results = jdbcTemplate.query(
            "select username, insect_no, username, insectname, old, habitat, description, reg_date from insect " +
                    "where insect_no > 0 order by insect_no asc",
            new RowMapper<Stagbeetle>() {
                @SneakyThrows
                @Override
                public Stagbeetle mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Stagbeetle stagbeetle = new Stagbeetle();

                    stagbeetle.setBulletinNo(rs.getInt("insect_no"));
                    stagbeetle.setUsername(rs.getString("username"));
                    stagbeetle.setInsectname(rs.getString("insectname"));
                    stagbeetle.setOld(rs.getString("old"));
                    stagbeetle.setHabitat(rs.getString("habitat"));
                    stagbeetle.setDescription(rs.getString("description"));

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    stagbeetle.setRegdate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                   return stagbeetle;
                }
            }
    );

    return results;
    }
}
