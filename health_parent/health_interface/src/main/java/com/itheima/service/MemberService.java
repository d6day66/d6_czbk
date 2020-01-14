package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.Member;

import java.util.List;

public interface MemberService {
    List<Integer> findMemberCountByMonth(List<String> list);

    Member findByTelephone(String telephone);

    void add(Member member);

    PageResult queryPage(QueryPageBean queryPageBean);

    void deleteById(Integer id);

    void editSave(Member member);
}
