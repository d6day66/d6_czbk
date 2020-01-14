package com.itheima.controller;

import com.aliyuncs.exceptions.ClientException;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.utils.RedisMessageConstant;
import com.itheima.utils.SMSUtils;
import com.itheima.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/validateCode")
public class ValidateCodeController {
    @Autowired
    private JedisPool jedisPool;
    @RequestMapping("/send4Order")
    public Result send4Order(String telephone){
        try {
            String code = ValidateCodeUtils.generateValidateCode4String(5);
            System.out.println(code+"---------------");
            SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE,telephone,code);
            jedisPool.getResource().setex(telephone+ RedisMessageConstant.SENDTYPE_ORDER,3000,code);
        } catch (ClientException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }
        return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);
    }
}
