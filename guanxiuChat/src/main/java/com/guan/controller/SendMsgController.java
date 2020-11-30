package com.guan.controller;

import com.guan.domain.dto.APIResponse;
import com.guan.service.SendMsgService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin
public class SendMsgController {
    @Autowired
    private SendMsgService sendMsgService;
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * @param phoneNumber
     * @return
     */
    @GetMapping("sendMsg")
    public APIResponse<Map<String, String>> sendMsg(String phoneNumber) {
        String code = redisTemplate.opsForValue().get(phoneNumber);
        Map<String, String> res = new HashMap<>();
        //调用发送方法
        if (!StringUtils.isEmpty(code)) {
            res.put("phoneNumber", phoneNumber);
            res.put("code", code);
            return APIResponse.success(res);
        }
        //生成验证码，并存储到redis中
        code = UUID.randomUUID().toString().substring(0, 4);
        //TODO
        code = "6666";
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", code);
//        boolean isSend = sendMsgService.sendMsg(phoneNumber, map);
        //todo
        boolean  isSend = true;
        if (isSend) {
            redisTemplate.opsForValue().set(phoneNumber, code, 5, TimeUnit.MINUTES);
            res.put("phoneNumber", phoneNumber);
            res.put("code", code);
            return APIResponse.success(res);
        }
        res.put(phoneNumber, "发送失败");
        return APIResponse.error(777, "发送失败", res);
    }
}
