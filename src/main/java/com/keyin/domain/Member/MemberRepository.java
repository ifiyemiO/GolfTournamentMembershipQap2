package com.keyin.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findMemberByMemberName(String name);
    List<Member> findByPhoneNumber(String phoneNumber);
}
