package com.example.personalProject2.repository;

import com.example.personalProject2.entity.BoardFree;
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
public class BoardRepositoryFree {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //메서드 앞에 throws Exception 이라고 붙이고 throw new Exception 구문에서 강제로 예외처리를 발생시킵니다.
    public void create(BoardFree boardfree) throws Exception  {
        String queryFree = "insert into boardfree (title, content, writer) values (?, ?, ?)";

        jdbcTemplate.update(queryFree, boardfree.getTitleFree(), boardfree.getContentFree(),
                boardfree.getWriterFree());
    }
    public List<BoardFree> listFree() throws Exception {
        List<BoardFree> results = jdbcTemplate.query(
                "select board_no, title, content, writer, reg_date from boardfree " +
                        "where board_no > 0 order by board_no desc",

                new RowMapper<BoardFree>() {
                    @SneakyThrows
                    @Override
                    public BoardFree mapRow(ResultSet rs, int rowNum) throws SQLException {
                        BoardFree board = new BoardFree();

                        board.setBoardNoFree(rs.getInt("board_no"));
                        board.setTitleFree(rs.getString("title"));
                        board.setContentFree(rs.getString("content"));
                        board.setWriterFree(rs.getString("writer"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        board.setRegDateFree(sdf.parse(rs.getDate("reg_date") + " " +
                                rs.getTime("reg_date")));

                        return board;
                    }
                }
        );

        return results;
    }

    public BoardFree read(Integer boardNo) throws Exception {
        List<BoardFree> results = jdbcTemplate.query(
                "select board_no, title, content, writer, reg_date from boardfree where board_no = ?",
                new RowMapper<BoardFree>() {
                    @Override
                    public BoardFree mapRow(ResultSet rs, int rowNum) throws SQLException {
                        BoardFree board = new BoardFree();

                        board.setBoardNoFree(rs.getInt("board_no"));
                        board.setTitleFree(rs.getString("title"));
                        board.setContentFree(rs.getString("content"));
                        board.setWriterFree(rs.getString("writer"));
                        board.setRegDateFree(rs.getDate("reg_date"));

                        return board;
                    }
                }, boardNo);

        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer boardNo) throws Exception {
        String query = "delete from boardfree where board_no = ?";

        jdbcTemplate.update(query, boardNo);

    }
}
