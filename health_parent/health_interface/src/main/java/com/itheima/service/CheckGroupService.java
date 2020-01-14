package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService {

    public void add(CheckGroup checkGroup,Integer[] ids);

    PageResult queryPage(QueryPageBean queryPageBean);

    List<Integer> queryGroupWithItems(Integer checkgroup_id);

    void deleteById(Integer id);

    List<CheckGroup> findAll();
}
