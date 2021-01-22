package com.guan.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guan.config.SnowflakeConfig;
import com.guan.controller.BsCityController;
import com.guan.controller.BsProvinceController;
import com.guan.controller.GuanChatController;
import com.guan.domain.BsCity;
import com.guan.domain.BsProvince;
import com.guan.domain.GuanChat;
import com.guan.domain.dto.APIResponse;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class GuanChatServiceImplTest extends TestCase {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123");

        System.out.println(password);

    }

    @Autowired
    private BsProvinceController bsProvinceController;
    @Autowired
    private BsCityController cityController;
    @Autowired
    private GuanChatController guanChatController;

    @Autowired
    SnowflakeConfig snowflakeConfig;

    @Test
    public void test01() {
        for (int i = 0; i < 10; i++) {
            System.out.println(snowflakeConfig.snowflakeId());
        }
    }

    @Test
    public void test02() {
        BsCity bsCity = cityController.cityTree(309);
        log.info(bsCity.toString());
    }

    @Test
    public void test03() {
        APIResponse<Page<GuanChat>> pageAPIResponse = guanChatController.listPage(1, 10);
        log.info(pageAPIResponse.getData().toString());
    }

    @Test
    public void test04() {
        GuanChat guanChat = new GuanChat()
                .setUserName("管秀荣")
                .setPhoneNumber("17788555555")
                .setPassWord("123")
                .setGender(0)
                .setMaritalStatus(0)
                .setEducation("本科")
                .setBirthday(LocalDate.now());
        APIResponse<Integer> one = guanChatController.saveOne(guanChat);
        log.info(one.getData().toString());
    }

}