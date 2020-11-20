package com.guan.config;

import cn.hutool.system.UserInfo;
import com.guan.domain.GuanChat;
import com.guan.mapper.GuanChatMapper;
import com.guan.service.IGuanChatService;
import com.guan.service.impl.GuanChatServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private IGuanChatService iGuanChatService;

/*    @Autowired
    private GuanChatMapper GuanChatMapper;*/


    @Override
    public UserDetails loadUserByUsername(String username) {

        log.info("loadUserByUsername->username={}", username);
        GuanChat guanChat = iGuanChatService.findByUsername(username);
        if (guanChat == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        //暂时不考虑权限
        List<GrantedAuthority> authorities = new ArrayList<>();
        String[] roles = guanChat.getRoles().split(",");
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        //已经在创建用户信息的时候做了加密处理，这里直接使用即可  返回UserDetails
        return new User(guanChat.getUserName(), guanChat.getPassWord(), authorities);
    }
}
