package com.guan.service;

import cn.hutool.system.UserInfo;
import com.guan.domain.GuanChat;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dzk
 * @since 2020-11-18
 */
public interface IGuanChatService extends IService<GuanChat> {

    int saveOne(GuanChat guanChat);

    GuanChat findByUsername(String username);

}
