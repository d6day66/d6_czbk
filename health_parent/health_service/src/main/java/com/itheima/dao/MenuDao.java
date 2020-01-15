package com.itheima.dao;

import com.itheima.pojo.Menu;

import java.util.LinkedHashSet;
import java.util.List;

public interface MenuDao {
    public LinkedHashSet<Menu> findByRoleId(Integer roleId);

    List<Menu> findAll();
}
