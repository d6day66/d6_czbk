package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.PermissionDao;
import com.itheima.pojo.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.MemberDao;
import com.itheima.dao.PermissionDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;
import com.itheima.pojo.Member;
import com.itheima.pojo.Permission;
import com.itheima.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service(interfaceClass = PermissionService.class)
@Transactional
public class PermissionServiceImpl implements PermissionService {


        PermissionDao permissionDao;
    @Override
    public List<Permission> findAll() {
      List<Permission> permissions =  permissionDao.findAll();
        return permissions;
    }
    @Override
    public void add(Permission permission) {
        permissionDao.add(permission);
    }

    @Override
    public PageResult queryPage(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage,pageSize);
        Page<Permission> permissions = permissionDao.selectPageCondition(queryString);
        return new PageResult(permissions.getTotal(),permissions.getResult());
    }
    @Override
    public void editSave(Permission permission) {
        permissionDao.editSave(permission);
    }

    @Override
    public void deleteById(Integer id) {
        permissionDao.deleteById(id);
    }
}