package com.itheima.service;

import com.itheima.pojo.Member;

import java.util.List;

public interface MemberService {
    List<Integer> findMemberCountByMonth(List<String> list);

    Member findByTelephone(String telephone);

    void add(Member member);
}
