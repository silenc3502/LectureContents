package com.example.demo.repository;

import com.example.demo.entity.Board;
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
        String query = "insert into board (title, content, writer) values (?, ?, ?)";

        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
    }

    public List<Board> list() throws Exception {
        List<Board> results = jdbcTemplate.query("select board_no, title, content, writer, reg_date from board " +
                        "where board_no > 0 order by board_no asc",

                new RowMapper<Board>() {
                    @SneakyThrows
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Board board = new Board();

                        board.setBoardNo(rs.getInt("board_no"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        board.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return board;
                    }
                }
        );
        return results;
    }

    public Board read (Integer boardNo) throws Exception {
        List<Board> results = jdbcTemplate.query(
                "select board_no, title, content, writer, reg_date from board where board_no = ?",
                //위의 list메소드와 달리 board_no과 일치하는 하나의 row값만 가져오기 때문에 'where board_no = ?'가 되는 것이다.

                //위의 ?는 service에서 인자로 받은 boardNo이 들어오는것인지??

                new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Board board = new Board();

                        board.setBoardNo(rs.getInt("board_no"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));
                        board.setRegDate(rs.getDate("reg_date"));

                        return board;
                    }
                }, boardNo);
        //service에서 인자로 받은 boardNo? 얘는 어떤 역할을 하는지 모르겠습니다.
        //이 boardNo이 ?로 들어가는것이 맞다.

        return results.isEmpty() ? null : results.get(0);
        //어짜피 boardNo과 일치하는 한 줄만 가져오니 0번째 줄을 result로 지정한다.
    }

    public void delete(Integer boardNo) throws Exception {
        String query = "delete from board where board_no = ?";

        jdbcTemplate.update(query, boardNo);
    }

    public void update(Board board) throws Exception {
        String query = "update board set title = ?, content = ? where board_no = ?";

        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getBoardNo());
    }


}
