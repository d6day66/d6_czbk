package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup;

import java.util.List;
import java.util.Map;

public interface CheckGroupDao {
    public void add(CheckGroup checkGroup);
    public void addT_checkitem_checkgroup(Map map);
    public Page<CheckGroup> selectPageCondition(String querryString);
    List<Integer> queryGroupWithItems(Integer id);
    void deleteById(Integer id);
    void deleteGroupAndItemKey(Integer id);

    List<CheckGroup> findAll();
}
