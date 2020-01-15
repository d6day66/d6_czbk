package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.Role;
import com.itheima.pojo.Setmeal;

import java.util.HashMap;
import java.util.Set;

public interface RoleDao {
    public Set<Role> findByUserId(Integer userId);

    void add(Role role);

    void addT_role_permission(HashMap<String, Integer> map);

    void addT_role_menu(HashMap<String, Integer> map);
    Page<Role> selectByCondition(String queryString);
}
