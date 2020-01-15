package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.Member;
import com.itheima.service.MemberService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Reference
    private MemberService memberService ;

    @RequestMapping("/add")
    public Result add(@RequestBody Member member){
        try {
            memberService.add(member);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "新增会员失败");
        }
        return new Result(true, "会员新增成功");
    }
    @RequestMapping("/pageQuery")
    public PageResult pageQuery(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = memberService.queryPage(queryPageBean);
        return pageResult;
    }

    @RequestMapping("/delete")
    public Result delete(Integer id){
        try {
            memberService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "此会员信息无法删除，联系管理员");
        }
        return new Result(true, "会员信息删除成功");
    }

    @RequestMapping("/editSave")
    public Result editSave(@RequestBody Member member){
        try {
            memberService.editSave(member);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "编辑会员信息失败");
        }
        return new Result(true, "会员信息修改成功");
    }
}
