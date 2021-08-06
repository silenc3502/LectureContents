package com.example.jswithspring.repository.jpa;

import com.example.jswithspring.entity.jpa.TestMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JPATestMemberRepository extends JpaRepository<TestMember, Long> {

    @Query("select mem from TestMember mem where mem.userId like %?1%")
    List<TestMember> findByJPQL(String userId);
}