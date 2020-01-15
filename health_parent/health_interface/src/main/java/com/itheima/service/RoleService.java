package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.pojo.Role;

import java.util.List;

public interface RoleService {

    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    void addRolePermissiomMenu(Role role, Integer[] permissionIds, Integer[] menuIds);

    void deleteById(Integer id);

    List<Integer> queryRoleWithMenu(Integer role_id);

    List<Integer> queryRoleWithpermission(Integer role_id);

    void edit(Role role, Integer[] permissionIds, Integer[] menuIds);
}
