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

    //++ db처리를 해야하기 때문에 exception
    public void create(Board board) throws Exception {
        // insert into board: DB에 있는 board 테이블에 값을 집어넣겠다.
        // (title, content, writer): board 테이블 내에 있는 컬럼들임
        // values (?, ?, ?): 뭔가 값을 넣을것인데 아직 미정이란 뜻
        String query = "insert into board (title, content, writer) values (?, ?, ?)";

        // jdbcTemplate.update(): 이것을 통해 실제 DB상의 값을 갱신함
        // query: 구동시킬 DB의 쿼리
        // 나머지 3개: query에 있는 ?에 배치할 값들을 결정함
        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
    }



    public List<Board> list() throws Exception {
        // RowMapper를 통해 얻은 행을 하나씩 List에 집어넣으니
        // results엔 DB에서 얻어온 행 정보들이 들어있다.
        List<Board> results = jdbcTemplate.query(
                // 셀렉트로 아래와같은 정보를 얻어온다.
                "select board_no, title, content, writer, reg_date from board " +
                        "where board_no > 0 order by board_no desc",
                // Row: 행
                // 여러개의 Column(열)들이 행 1개에 포함되어 있음
                // 여러 열들을 얻어와서 행으로 맵핑하는 작업을 수행함

                // jpa를 쓰면 해당 내용들이 싹다없어짐. 지금은 전부 수기로 입력해서 데이터를 넣는 작업
                // ++다만 jpa를 쓰더라도 해당 개념을 습득하고 있어야 jpa를 사용할 수 있음
                new RowMapper<Board>() {
                    @SneakyThrows
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Board board = new Board();

                        // rs.getInt()는 DB에 있는 정수형 정보를 얻어옴
                        board.setBoardNo(rs.getInt("board_no"));
                        // rs.getString()은 DB에 있는 문자열 정보를 얻어옴
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));
                        // rs.getDate()는 DB에 있는 날자 정보를 얻어옴
                        // board.setRegDate(rs.getDate("reg_date"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


                        board.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        //System.out.println("rs.getDate(): " + rs.getTimestamp("reg_date"));
                        //System.out.println("rs.getDate(): " + rs.getDate("reg_date"));
                        //System.out.println("rs.getTime(): " + rs.getTime("reg_date"));

                        return board;
                    }
                }
        );                //++ 익명객체의 특성

        return results;
    }
    // seventhController
    public Board read (Integer boardNo) throws Exception {
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

                        // board가 리턴이 되는데 List<Board> results 에 들어가게됨
                        return board;
                    }
                }, boardNo);

        //++ empty일경우 0값을 받게 됨.
        // results에 기록된 내용이 list.
        // results.isEmpty() 리스트에 값이 있냐? 리스트가 비었냐?
        // 비었다면 null, 비어있지 않았다면 results.get(0)
        // 0번 인덱스(노드)의 리스트를 리턴
        // 비어있다면 null, 비어있지않다면 값을 가져와라.
        return results.isEmpty() ? null : results.get(0);
    }

    public void delete(Integer boardNo) throws Exception {
        //+ 번호를 지워버리겠습니다 라는 말
        String query = "delete from board where board_no = ?";

        jdbcTemplate.update(query, boardNo);
    }

    public void update(Board board) throws Exception {
        String query = "update board set title = ?, content = ? where board_no = ?";

        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getBoardNo());
    }
}