package com.example.demo.repository;

import com.example.demo.entity.Member;
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
public class MemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Member member) throws Exception {
        String query = "insert into memberList (id, pw, name, gender, age, location, interestedGenre, interestedArtist) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(query, member.getId(), member.getPw(), member.getName(), member.getGender(), member.getAge(),
                member.getLocation(), member.getInterestedGenre(), member.getInterestedArtist());
    }

    public Boolean loginCheck(Member member) throws Exception {

        List<Member> results = jdbcTemplate.query(
                "select id, pw from memberList where id = ?",

                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();
                        member.setId(rs.getString("id"));
                        member.setPw(rs.getString("pw"));
                        return member;
                    }
                }, member.getId()
        );

        if(results.isEmpty() == true) {
            log.info("Not registered ID");
            return false;
        }

        Member tmp = results.get(0);
        log.info("tmp : " + tmp);

        if (tmp.getId().equals(member.getId()) && tmp.getPw().equals(member.getPw())) {
            log.info("Access Allowed!");
            return true;
        } else {
            log.info("Access Denied.");
            return false;
        }
    } //login check

    public List<Member> list() throws Exception {
        List<Member> results = jdbcTemplate.query(
                "select member_no, id, pw, name, gender, age, location, interestedGenre, interestedArtist, " +
                        "reg_date from memberList where member_no > 0 order by member_no asc",

                new RowMapper<Member>() {
                    @SneakyThrows
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setMemberNo(rs.getInt("member_No"));
                        member.setId(rs.getString("id"));
                        member.setPw(rs.getString("pw"));
                        member.setName(rs.getString("name"));
                        member.setGender(rs.getString("gender"));
                        member.setAge(rs.getInt("age"));
                        member.setLocation(rs.getString("location"));
                        member.setInterestedGenre(rs.getString("interestedGenre"));
                        member.setInterestedArtist(rs.getString("interestedArtist"));

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        member.setRegDate(sdf.parse(rs.getDate("reg_date") + " " + rs.getTime("reg_date")));

                        return member;
                    }
                }
        );
        return results;
    }

    public void delete(String id, String pw) throws Exception {
        log.info("parameterId: " + id);
        log.info("parameterPw: " + pw);

        List<Member> results = jdbcTemplate.query("select id, pw from memberList where id = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Member member = new Member();

                        member.setId(rs.getString("id"));
                        member.setPw(rs.getString("pw"));
                        return member;
                    }
                }, id);

        Member targetMember = results.get(0);

        log.info("targetId: " + targetMember.getId());
        log.info("targetPw: " + targetMember.getPw());

        if(id.equals(targetMember.getId()) && (pw.equals(targetMember.getPw()))) {
            String query = "delete from memberList where id = ?";
            jdbcTemplate.update(query, id);
        } else {
            log.info("Cannot delete account due to input of wrong id or pw.");
        } //동일한 id 삭제하는것 방지 처리 아직 미구현.

    }
}
