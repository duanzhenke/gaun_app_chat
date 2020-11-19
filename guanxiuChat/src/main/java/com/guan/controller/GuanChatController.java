package com.guan.controller;


import com.guan.domain.GuanChat;
import com.guan.domain.dto.APIResponse;
import com.guan.service.IGuanChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dzk
 * @since 2020-11-18
 */
@RestController
@RequestMapping("/guanChat")
public class GuanChatController {

    @Autowired
    private IGuanChatService iGuanChatService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("saveOne")
    public APIResponse<Integer> saveOne(GuanChat guanChat) {
        return APIResponse.success(iGuanChatService.saveOne(guanChat));
    }
}

