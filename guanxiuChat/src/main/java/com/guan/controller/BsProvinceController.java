package com.guan.controller;


import com.guan.domain.BsCity;
import com.guan.domain.BsProvince;
import com.guan.service.IBsCityService;
import com.guan.service.IBsProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 省份设置 前端控制器
 * </p>
 *
 * @author dzk
 * @since 2020-11-10
 */
@RestController
@RequestMapping("/bsProvince")
public class BsProvinceController {

    @Autowired
    private IBsProvinceService iBsProvinceService;

    @GetMapping("getById/{provinceId}")
    public BsProvince getById(@PathVariable(value = "provinceId") Integer provinceId) {
        return iBsProvinceService.getById(provinceId);
    }
}

