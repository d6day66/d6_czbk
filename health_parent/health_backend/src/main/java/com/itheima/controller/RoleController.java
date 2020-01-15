package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.Role;
import com.itheima.service.RoleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Reference
    private RoleService roleService;

//    添加角色-权限-菜单。前台传入权限ids、菜单ids和角色基本信息
    @RequestMapping("/addRolePermissiomMenu")
    public Result addPermissiom(@RequestBody Role role, Integer[] permissionIds,Integer[] menuIds){

        try {
            roleService.addRolePermissiomMenu(role,permissionIds,menuIds);


        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_ROLE_FAIL);
        }
        return new Result(true, MessageConstant.ADD_ROLE_SUCCESS);
    }
//      分页查询
    @RequestMapping("/pageQuery")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = roleService.pageQuery(
                queryPageBean.getCurrentPage(),
                queryPageBean.getPageSize(),
                queryPageBean.getQueryString()
        );
        return pageResult;
    }
//      删除
    @RequestMapping("/delete")
    public Result delete(Integer id){
        try {
            roleService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_ROLE_FAIL);
        }
        return new Result(true, MessageConstant.DELETE_ROLE_SUCCESS);
    }
//    弹出编辑通过roleId获取menuIds
    @RequestMapping("/queryRoleWithMenu")
    public List<Integer> queryRoleWithMenu(Integer role_id){
        List<Integer> list=roleService.queryRoleWithMenu(role_id);
        return list;
    }
    //    弹出编辑通过roleId获取permissionIds
    @RequestMapping("/queryRoleWithpermission")
    public List<Integer> queryRoleWithpermission(Integer role_id){
        List<Integer> list=roleService.queryRoleWithpermission(role_id);
        return list;
    }

    //    编辑
    @RequestMapping("/edit")
    public Result edit(@RequestBody Role role, Integer[] permissionIds,Integer[] menuIds){
       try {

           roleService.edit(role, permissionIds, menuIds);
           return new Result(true, MessageConstant.EDIT_ROLE_SUCCESS);
       }catch (Exception e){
           e.printStackTrace();
           return new Result(false, MessageConstant.EDIT_ROLE_FAIL);
       }
    }

}
