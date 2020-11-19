package com.guan.service.impl;

import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guan.domain.GuanChat;
import com.guan.mapper.GuanChatMapper;
import com.guan.service.IGuanChatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dzk
 * @since 2020-11-18
 */
@Service
public class GuanChatServiceImpl extends ServiceImpl<GuanChatMapper, GuanChat> implements IGuanChatService {

    @Resource
    private GuanChatMapper guanChatMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public int saveOne(GuanChat guanChat) {
        guanChat.setPassWord(passwordEncoder.encode(guanChat.getPassWord()));
        return guanChatMapper.insert(guanChat);
    }

    /**
     * 通过用户名查找用户信息
     *
     * @param username 用户的姓名
     * @return GuanChat
     */
    @Override
    public GuanChat findByUsername(String username) {
        return guanChatMapper.selectOne(new QueryWrapper<>(new GuanChat().setUserName(username)));
    }
}
