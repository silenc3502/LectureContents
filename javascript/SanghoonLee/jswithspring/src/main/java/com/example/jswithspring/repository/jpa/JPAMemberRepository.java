package com.example.jswithspring.repository.jpa;

import com.example.jswithspring.entity.jpa.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JPAMemberRepository extends JpaRepository<Member, Long> {
}