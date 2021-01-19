package com.guan.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guan.domain.GuanChat;
import com.guan.domain.dto.APIResponse;
import com.guan.service.IGuanChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
@CrossOrigin
@RequestMapping("/guanChat")
public class GuanChatController {

    @Autowired
    private IGuanChatService iGuanChatService;

    @GetMapping("/hello")
    public String hello() {
        return "hello 管秀荣7777777";
    }

    /**
     * 新增用户 其实就是 注册一个用户
     *
     * @param guanChat 用户主体
     * @return APIResponse<Integer>
     */
    @PostMapping("saveOne")
    public APIResponse<Integer> saveOne(@RequestBody GuanChat guanChat) {
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

    /**
     * 删除一个用户 TODO 应该逻辑删除
     *
     * @param userId
     * @return
     */
    @DeleteMapping
    public APIResponse<Boolean> delOne(Float userId) {
        return APIResponse.success(iGuanChatService.removeById(userId));
    }

    /**
     * 修改一个用户
     *
     * @param guanChat 修改的实体用户
     * @return APIResponse 布尔类型
     */
    @PostMapping("updateOne")
    public APIResponse<Boolean> updateOne(@RequestBody GuanChat guanChat) {
        return APIResponse.success(iGuanChatService.updateById(guanChat));
    }


    /**
     * 查找一个用户
     *
     * @param userId 根据用户id ,获取用户的详细信息
     * @return APIResponse 布尔类型
     */
    @GetMapping("detailUser")
    public APIResponse<GuanChat> detailUser(Float userId) {
        return APIResponse.success(iGuanChatService.getById(userId));
    }

}

