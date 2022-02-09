package com.example.jswithspring.repository.jpa;

import com.example.jswithspring.entity.jpa.ManyToManyMember;
import com.example.jswithspring.entity.jpa.ManyToManyMemberAuth;
//import com.example.jswithspring.entity.jpa.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JpaManyToManyTestMemberRepository extends JpaRepository<ManyToManyMember, Long> {

    //@Query("select m from ManyToManyMember m join fetch m.authList where m.memberNo = :memberNo")
    //Optional<ManyToManyMember> findByAuth(Long memberNo);

    //@Query("select m from ManyToManyMember m where m.userId = :userId")
    //Optional<ManyToManyMember> findByUserId(String userId);

    @Query(value = "select m from tbl_many_to_many_member m where m.member_no in (select ma.many_to_many_member_no from tbl_many_to_many_member_auth ma where ma.auth = :auth", nativeQuery = true)
    public List<ManyToManyMember> selectMemberWithRole(String auth);
}