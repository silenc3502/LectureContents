package com.example.projectTest.repository;

import com.example.projectTest.entity.Project;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

@Slf4j
@Repository
public class ProjectRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Project project) {
        String query = "insert into project (id, password, username, birth) values (?, ?, ?, ?)";

        jdbcTemplate.update(query, project.getId(),project.getPassword(),project.getUsername(),project.getBirth());
    }

    public List<Project> list() throws Exception {
        List<Project> results = jdbcTemplate.query(
                "select signup_no, id, password, username, birth, reg_date from project " +
                        "where signup_no > 0 order by signup_no desc",
                new RowMapper<Project>() {
                    @SneakyThrows
                    @Override
                    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Project project = new Project();

                        project.setSignupNo(rs.getInt("signup_no"));
                        project.setId(rs.getString("id"));
                        project.setPassword(rs.getString("password"));
                        project.setUsername(rs.getString("username"));
                        project.setBirth(rs.getInt("birth"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        project.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return project;
                    }
                }
        );

        return results;
    }

    public Project read (Integer signupNo) throws Exception {
        List<Project> results = jdbcTemplate.query(
                "select signup_no, id, password,username, birth, reg_date from project where signup_no = ?",
                new RowMapper<Project>() {
                    @Override
                    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Project project = new Project();

                        project.setSignupNo(rs.getInt("signup_no"));
                        project.setId(rs.getString("id"));
                        project.setPassword(rs.getString("password"));
                        project.setUsername(rs.getString("username"));
                        project.setBirth(rs.getInt("birth"));


                        return project;
                    }
                }, signupNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer signupNo) throws Exception {
        String query = "delete from project where signup_no = ?";

        jdbcTemplate.update(query, signupNo);
    }

    public void update(Project project) throws Exception {
        String query = "update project set password = ? where signup_no = ?";

        jdbcTemplate.update(query, project.getPassword(), project.getSignupNo());
    }

    public void login(Project project) throws Exception {

        List<Project> results = jdbcTemplate.query(
                "select id, password from project where id = ?",

                new RowMapper<Project>() {
                    @Override
                    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Project project = new Project();

                        project.setId(rs.getString("id"));
                        project.setPassword(rs.getString("password"));

                        return project;
                    }
                }, project.getId());

        Project tmp = results.get(0);
        log.info("tmp: " + tmp);

        if (tmp.getPassword().equals(project.getPassword())) {
            log.info("Password Correct");
        } else {
            log.info("Password Incorrect");
        }
    }
}