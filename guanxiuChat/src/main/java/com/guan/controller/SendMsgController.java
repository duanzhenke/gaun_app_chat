package com.guan.controller;

import com.guan.service.SendMsgService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@CrossOrigin
public class SendMsgController {
    @Autowired
    private SendMsgService sendMsgService;
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     *
     * @param phoneNumber
     * @return
     */
    @GetMapping("sendMsg")
    public String sendMsg(String phoneNumber) {
        String code = redisTemplate.opsForValue().get(phoneNumber);
        //调用发送方法
        if (!StringUtils.isEmpty(code)) {
            return phoneNumber + ":" + code + "已存在，没过期";
        }
        //生成验证码，并存储到redis中
        code = UUID.randomUUID().toString().substring(0, 4);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", code);
        boolean isSend = sendMsgService.sendMsg(phoneNumber, map);
        if (isSend) {
            redisTemplate.opsForValue().set(phoneNumber, code, 5, TimeUnit.MINUTES);
            return phoneNumber + ":" + code + "发送成功";
        }
        return "短信验证码，发送失败：";
    }
}
