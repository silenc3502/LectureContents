package com.example.demo.repository;

import com.example.demo.entity.Board;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
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
        String query = "insert into board (title, content, writer) values (? ,? ,?)";
        // insert into board: DB에 있는 board 테이블에 값을 집어넣는다.
        // (title, content, writer): board 내에 있는 컬럼
        // values (?,?,?): 값을 넣을 것인데 무엇을 넣을 지 모른다는 뜻
        // * 사용자가 입력한 정보가 저장됨 (mysql에서 select * from board; 를 치면 입력한 정보를 확인할 수 있음) *

        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
    }
    public List<Board> list() throws Exception{
        // RowMappter를 통해 얻은 행을 하나씩 List에 집어 넣음
        // results엔 DB에서 얻어온 행 정보들이 들어감

        List<Board> results = jdbcTemplate.query(
                "select board_no, title, content, writer, reg_date from board " +
                        "where board_no > 0 order by board_no desc",

                // board_no, title, content, writer, reg_date: mysql 상에서 *을 풀어서 쓴 것
                // where board_no > 0 : if문, desc: descent 내림차순 -> boar_no가 0보다 크면 내림차순으로 정렬
                // new RowMapper<>(): Row(행), 여러 개의 열들이 하나의 행에 포함되어 있으므로 여러 열들을 얻어와 행으로 맵핑 함
                //                    입력하면 오버라이드 자동 완성 됨

                new RowMapper<Board>() {
                    @SneakyThrows
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Board board = new Board();

                        // rs.getInt(): DB에 있는 정수형 정보를 얻어옴
                        board.setBoardNo(rs.getInt("board_no"));
                        // rs.getString(): DB에 있는 문자열 정보를 얻어옴
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));
                        // rs.getTimestamp(): DB에 있는 날짜 + 시간 정보를 얻어옴(이건 날짜,시간이 안맞음)
                        // rs.getDate(): DB에 있는 날짜 정보를 얻어옴
                        // rs.getTime(): DB에 있는 시간 정보를 얻어옴
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        board.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return board;
                    }
                });
        return results;
    }

    public Board read(Integer boardNo) throws Exception{
    List<Board> results = jdbcTemplate.query(
            "select board_no, title, content, writer, reg_date from board where board_no = ?",
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
    return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer boardNo) throws Exception{
        String query = "delete from board where board_no = ?";

        jdbcTemplate.update(query, boardNo);
    }

    public void update(Board board) throws Exception{
        String query = "update board set title=?, content=? where board_no=?";

        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getBoardNo());
    }


}
















