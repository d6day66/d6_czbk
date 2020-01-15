package com.itheima.service;

import com.itheima.pojo.Permission;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.Member;
import com.itheima.pojo.Permission;
import java.util.List;
import java.util.List;

public interface PermissionService {
    List<Permission> findAll();
    void add(Permission permission);
    public PageResult queryPage(QueryPageBean queryPageBean);
    void editSave(Permission permission);
    void deleteById(Integer id);
}

