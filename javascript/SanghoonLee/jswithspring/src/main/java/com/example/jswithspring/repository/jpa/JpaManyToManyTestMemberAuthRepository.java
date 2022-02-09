package com.example.jswithspring.repository.jpa;

import com.example.jswithspring.entity.jpa.ManyToManyMemberAuth;
//import com.example.jswithspring.entity.jpa.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JpaManyToManyTestMemberAuthRepository extends JpaRepository<ManyToManyMemberAuth, Long> {

    //@Query("select auth from ManyToManyMemberAuth ma where ma.memberNo = :memberNo")
    //Optional<ManyToManyMemberAuth> findByMemberNo(Long memberNo);

    List<ManyToManyMemberAuth> findByAuth(@Param("auth") String auth);
}