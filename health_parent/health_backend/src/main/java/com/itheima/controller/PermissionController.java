package com.itheima.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckItem;
import com.itheima.pojo.Permission;
import com.itheima.service.CheckItemService;
import com.itheima.service.PermissionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.Member;
import com.itheima.pojo.Permission;
import com.itheima.service.PermissionService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Reference
    private PermissionService permissionService;


    @RequestMapping("/findAll")
    public Result findAll(){
        try {
            List<Permission> list = permissionService.findAll();
            return new Result(true, MessageConstant.QUERY_PEMISSION_SUCCESS,list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_PEMISSION_FAIL);
        }
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Permission  permission){
        try {
            permissionService.add(permission);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "新增权限失败");
        }
        return new Result(true, "新增权限成功");
    }
    @RequestMapping("/pageQuery")
    public PageResult pageQuery(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult =permissionService.queryPage(queryPageBean);
        return pageResult;
    }
    @RequestMapping("/editSave")
    public Result editSave(@RequestBody Permission permission){
        try {
            permissionService.editSave(permission);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "编辑权限信息失败");
        }
        return new Result(true, "权限信息修改成功");
    }
    @RequestMapping("/delete")
    public Result delete(Integer id) {
        try {
            permissionService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "此权限信息无法删除，联系管理员");
        }
        return new Result(true, "权限信息删除成功");
    }
}
