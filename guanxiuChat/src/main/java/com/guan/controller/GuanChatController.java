package com.guan.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guan.domain.GuanChat;
import com.guan.domain.dto.APIResponse;
import com.guan.service.IGuanChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    /**
     * 新增用户 其实就是 注册一个用户
     *
     * @param guanChat
     * @return
     */
    @PostMapping("saveOne")
    public APIResponse<Integer> saveOne(GuanChat guanChat) {
        return APIResponse.success(iGuanChatService.saveOne(guanChat));
    }


    /**
     * 展示页概览   学历 身高 marrystatus 刷选
     *
     * @param current 当前页
     * @param size    每页大小
     * @return APIResponse<Page < GuanChat>>
     */
    @GetMapping("/listPage")
    public APIResponse<Page<GuanChat>> listPage(Integer current, Integer size) {
        Page<GuanChat> guanChatPage = iGuanChatService.selectPageVo(current, size);
        return APIResponse.success(guanChatPage);
    }
}

