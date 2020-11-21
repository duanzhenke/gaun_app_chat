/*
package com.guan.config;

import com.guan.filter.VerifyFilter;
import com.guan.mapper.GuanChatMapper;
import com.guan.service.IGuanChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;

*/
/**
 * @Author: oyc
 * @Date: 2019/1/29 13:45
 * @Description:
 *//*

@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig01 extends WebSecurityConfigurerAdapter {

    @Resource
    private MyUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        //SpringSecurity 提供的一种编码器，我们也可以自己实现PasswordEncoder
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        // 在这里将 UserDetailsSercie 实例注入
        try {
            auth.userDetailsService(userDetailsService);
        } catch (Exception e) {
            log.error("Set userDetailService failed, {}", e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 如果有允许匿名的url，填在下面
                .antMatchers("/getVerifyCode").permitAll()
                .anyRequest().authenticated()
                .and()
                // 设置登陆页
                .formLogin().loginPage("/login")
                // 设置登陆成功页
                .defaultSuccessUrl("/").permitAll()
                // 登录失败Url
                .failureUrl("/guan_error")
                .and()
                // 在用户名和密码之前 设置过滤器
                .addFilterBefore(new VerifyFilter(), UsernamePasswordAuthenticationFilter.class)
                .logout().permitAll()
                .and().rememberMe()
        ;
        // 关闭CSRF跨域
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**");
    }
}
*/
