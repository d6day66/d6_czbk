package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.Role;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface RoleDao {
    public Set<Role> findByUserId(Integer userId);

    void add(Role role);

    void addT_role_permission(HashMap<String, Integer> map);

    void addT_role_menu(HashMap<String, Integer> map);
    Page<Role> selectByCondition(String queryString);

    void deleteById(Integer id);

    List<Integer> queryRoleWithMenu(Integer role_id);

    List<Integer> queryRoleWithpermission(Integer role_id);

    void edit(Role role);

}
