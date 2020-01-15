package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.pojo.Role;

public interface RoleService {

    PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

    void addRolePermissiomMenu(Role role, Integer[] permissionIds, Integer[] menuIds);

    void deleteById(Integer id);
}
