package com.example.personalProject2.repository;

import com.example.personalProject2.entity.BoardFree;
import com.example.personalProject2.entity.BoardNotice;
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
public class BoardRepositoryNotice {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //메서드 앞에 throws Exception 이라고 붙이고 throw new Exception 구문에서 강제로 예외처리를 발생시킵니다.
    public void create(BoardNotice boardnotice) throws Exception  {
        String queryNotice = "insert into boardnotice (title, content, writer) values (?, ?, ?)";

        jdbcTemplate.update(queryNotice, boardnotice.getTitleNotice(), boardnotice.getContentNotice(),
                boardnotice.getWriterNotice());
    }
    public List<BoardNotice> listNotice() throws Exception {
         List<BoardNotice> results = jdbcTemplate.query(
                 "select board_no, title, content, writer, reg_date from boardnotice " +
                        "where board_no > 0 order by board_no desc",

                new RowMapper<BoardNotice>() {
                    @SneakyThrows
                    @Override
                    public BoardNotice mapRow(ResultSet rs, int rowNum) throws SQLException {
                        BoardNotice board = new BoardNotice();

                        board.setBoardNoNotice(rs.getInt("board_no"));
                        board.setTitleNotice(rs.getString("title"));
                        board.setContentNotice(rs.getString("content"));
                        board.setWriterNotice(rs.getString("writer"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        board.setRegDateNotice(sdf.parse(rs.getDate("reg_date") + " " +
                                rs.getTime("reg_date")));

                        return board;
                    }
                }
        );

         return results;
    }

    public BoardNotice read(Integer boardNo) throws Exception {
        List<BoardNotice> results = jdbcTemplate.query(
                "select board_no, title, content, writer, reg_date from boardnotice where board_no = ?",
                new RowMapper<BoardNotice>() {
                    @Override
                    public BoardNotice mapRow(ResultSet rs, int rowNum) throws SQLException {
                        BoardNotice board = new BoardNotice();

                        board.setBoardNoNotice(rs.getInt("board_no"));
                        board.setTitleNotice(rs.getString("title"));
                        board.setContentNotice(rs.getString("content"));
                        board.setWriterNotice(rs.getString("writer"));
                        board.setRegDateNotice(rs.getDate("reg_date"));

                        return board;
                    }
                }, boardNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer boardNo) throws Exception {
        String query = "delete from boardnotice where board_no = ?";

        jdbcTemplate.update(query, boardNo);

    }
}
