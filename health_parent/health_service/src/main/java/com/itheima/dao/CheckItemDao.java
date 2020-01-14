package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;

import java.util.List;

public interface CheckItemDao {
    public void add(CheckItem checkItem);
    public Page<CheckItem> selectPageCondition(String querryString);
    int findCountInCheckItemGroup(Integer id);
    void deleteById(Integer id);

    void editSave(CheckItem checkItem);

    List<CheckItem> findAll();
}
