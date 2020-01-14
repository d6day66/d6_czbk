package com.itheima.dao;
import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;
import com.itheima.pojo.Member;
import com.itheima.pojo.Permission;
import java.util.Set;
public interface PermissionDao {
    public Set<Permission> findByRoleId(Integer roleId);
    void add(Permission permission);
    public Page<Permission> selectPageCondition(String querryString);
    void editSave(Permission permission);
    public void deleteById(Integer id);
}
