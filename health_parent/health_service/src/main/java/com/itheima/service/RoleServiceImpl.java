package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.MenuDao;
import com.itheima.dao.PermissionDao;
import com.itheima.dao.RoleDao;
import com.itheima.entity.PageResult;
import com.itheima.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service(interfaceClass = RoleService.class)
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private MenuDao menuDao;

    //    分页查询
    @Override
    public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
        PageHelper.startPage(currentPage, pageSize);
        Page<Role> page = roleDao.selectByCondition(queryString);
        return new PageResult(page.getTotal(), page.getResult());
    }

    //角色新建增加中间关系
    @Override
    public void addRolePermissiomMenu(Role role, Integer[] permissionIds, Integer[] menuIds) {
        roleDao.add(role);
        Integer roleId = role.getId();
        setRoleAndPermissionMenu(roleId,permissionIds,menuIds);

    }

    //删除
    @Override
    public void deleteById(Integer id) {
        permissionDao.deleteRoleAndPermission(id);
        menuDao.deleteRoleAndMenu(id);
        roleDao.deleteById(id);
    }

    //根据roleid查询菜单
    @Override
    public List<Integer> queryRoleWithMenu(Integer role_id) {
        return roleDao.queryRoleWithMenu(role_id);
    }

    //根据roleid查询权限
    @Override
    public List<Integer> queryRoleWithpermission(Integer role_id) {
        return roleDao.queryRoleWithpermission(role_id);
    }

    //编辑
    @Override
    public void edit(Role role, Integer[] permissionIds, Integer[] menuIds) {
//        根据基本信息更新role信息
        roleDao.edit(role);
        Integer roleId = role.getId();
//        删除关系
        permissionDao.deleteRoleAndPermission(roleId);
        menuDao.deleteRoleAndMenu(roleId);
//        新增关系
        setRoleAndPermissionMenu(roleId,permissionIds,menuIds);
    }

//    新增关系方法
    public void setRoleAndPermissionMenu(Integer roleId,Integer[] permissionIds, Integer[] menuIds){
        if (permissionIds != null && permissionIds.length > 0) {
            for (Integer permissionId : permissionIds) {
                HashMap<String, Integer> map = new HashMap<>();
                map.put("role_id", roleId);
                map.put("permission_id", permissionId);
                roleDao.addT_role_permission(map);
            }
        }
        if (menuIds != null && menuIds.length > 0) {
            for (Integer menuId : menuIds) {
                HashMap<String, Integer> map = new HashMap<>();
                map.put("role_id", roleId);
                map.put("menu_id", menuId);
                roleDao.addT_role_menu(map);
            }
        }
    }

}
