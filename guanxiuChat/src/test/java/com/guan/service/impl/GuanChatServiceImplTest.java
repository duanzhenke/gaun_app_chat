package com.guan.service.impl;

import com.guan.controller.BsCityController;
import com.guan.controller.BsProvinceController;
import com.guan.domain.BsCity;
import com.guan.domain.BsProvince;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void test01() {
        BsProvince provinceTree = bsProvinceController.getProvinceTree(27);
        log.info(provinceTree.toString());
    }

    @Test
    public void test02() {
        BsCity bsCity = cityController.cityTree(309);
        log.info(bsCity.toString());
    }

}