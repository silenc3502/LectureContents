package com.example.Project.repository;


import com.example.Project.entity.Board;
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
public class BoardRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Board board) throws Exception {
        String query = "insert into board (title, content, writer) values (?,?,?)";

        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
    }

    RowMapper board = new RowMapper() {
        @SneakyThrows
        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Board board = new Board();

            board.setBoardNo(rs.getInt("board_no"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setWriter(rs.getString("writer"));
            board.setRegDate(rs.getDate("reg_date"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            board.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));
            return board;
        }
    };

    public List<Board> list() {
        List<Board> results = jdbcTemplate.query(
                "select board_no, title, content, writer, reg_date from board " +
                        "where board_no > 0 order by board_no desc", board
        );
        return results;
    }

    public Board read(Integer boardNo) throws Exception {
        List<Board> results = jdbcTemplate.query(
                "select board_no, title, content, writer, reg_date from board where board_no = ?",
                board, boardNo);
        return results.isEmpty() ? null : results.get(0);
    }


}


