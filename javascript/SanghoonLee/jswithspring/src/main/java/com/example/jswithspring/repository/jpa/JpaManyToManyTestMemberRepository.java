package com.example.jswithspring.repository.jpa;

import com.example.jswithspring.entity.jpa.ManyToManyMember;
import com.example.jswithspring.entity.jpa.ManyToManyMemberAuth;
//import com.example.jswithspring.entity.jpa.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface JpaManyToManyTestMemberRepository extends JpaRepository<ManyToManyMember, Long> {

    //@Query("select m from ManyToManyMember m join fetch m.authList where m.memberNo = :memberNo")
    //Optional<ManyToManyMember> findByAuth(Long memberNo);

    //@Query("select m from ManyToManyMember m where m.userId = :userId")
    //Optional<ManyToManyMember> findByUserId(String userId);

    @Transactional
    @Query(value = "select * from tbl_many_to_many_member where member_no in (select many_to_many_member_no from tbl_many_to_many_member_auth where auth = :auth)", nativeQuery = true)
    public List<ManyToManyMember> selectMemberWithRole(String auth);

    //@Query(value = "select * from tbl_many_to_many_member where member_no in :#{#paramSnack.id}", nativeQuery = true)
    //public List<ManyToManyMember> selectSQLById3(@Param(value = "paramMemberAuth") ManyToManyMemberAuth paramMeberAuth);
}