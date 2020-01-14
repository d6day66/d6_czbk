package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

import java.util.List;

public interface CheckItemService {
    public void add(CheckItem checkItem);
    public PageResult queryPage(QueryPageBean queryPageBean);

    void deleteById(Integer id);

    void editSave(CheckItem checkItem);

    List<CheckItem> findAll();
}
