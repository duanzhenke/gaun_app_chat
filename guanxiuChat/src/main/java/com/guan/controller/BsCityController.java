package com.guan.controller;


import com.guan.domain.BsArea;
import com.guan.domain.BsCity;
import com.guan.domain.BsProvince;
import com.guan.service.IBsCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 城市设置 前端控制器
 * </p>
 *
 * @author dzk
 * @since 2020-11-10
 */
@RestController
@RequestMapping("/bsCity")
public class BsCityController {
    @Autowired
    private IBsCityService iBsCityService;

    @GetMapping("getById/{cityId}")
    public BsCity getById(@PathVariable(value = "cityId") Integer cityId) {
        return iBsCityService.getById(cityId);
    }

    @GetMapping("cityTree/{cityId}")
    public BsCity cityTree(@PathVariable(value = "cityId") Integer cityId) {
        return iBsCityService.getCityTree(cityId);
    }
}

