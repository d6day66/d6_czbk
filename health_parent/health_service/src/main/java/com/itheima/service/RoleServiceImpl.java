package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.RoleDao;
import com.itheima.entity.PageResult;
import com.itheima.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
@Service(interfaceClass = RoleService.class)
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;



//    @Override
//    public void addPermissiom(Role role, Integer[] permissionIds) {
//        roleDao.add(role);
//        Integer roleId = role.getId();
//        if(permissionIds!=null &&permissionIds.length>0){
//            for (Integer permissionId : permissionIds) {
//                HashMap<String, Integer> map = new HashMap<>();
//                map.put("role_id",roleId);
//                map.put("permission_id",permissionId);
//                roleDao.addT_role_permission(map);
//            }
//        }
//    }
//
//    @Override
//    public void addMenu(Role role, Integer[] menuIds) {
//        roleDao.add(role);
//        Integer roleId = role.getId();
//        if(menuIds!=null &&menuIds.length>0){
//            for (Integer menuId : menuIds) {
//                HashMap<String, Integer> map = new HashMap<>();
//                map.put("role_id",roleId);
//                map.put("menu_id",menuId);
//                roleDao.addT_role_menu(map);
//            }
//        }
//    }
    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        PageHelper.startPage(currentPage,pageSize);
        Page<Role> page = roleDao.selectByCondition(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void addRolePermissiomMenu(Role role, Integer[] permissionIds, Integer[] menuIds) {
        roleDao.add(role);
        Integer roleId = role.getId();
        if(permissionIds!=null &&permissionIds.length>0){
            for (Integer permissionId : permissionIds) {
                HashMap<String, Integer> map = new HashMap<>();
                map.put("role_id",roleId);
                map.put("permission_id",permissionId);
                roleDao.addT_role_permission(map);
            }
        }
        if(menuIds!=null &&menuIds.length>0){
            for (Integer menuId : menuIds) {
                HashMap<String, Integer> map = new HashMap<>();
                map.put("role_id",roleId);
                map.put("menu_id",menuId);
                roleDao.addT_role_menu(map);
            }
        }
    }

}
