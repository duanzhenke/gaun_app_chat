package com.guan.controller;


import com.guan.domain.BsArea;
import com.guan.service.IBsAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 地区设置 前端控制器
 * </p>
 *
 * @author dzk
 * @since 2020-11-10
 */
@RestController
@RequestMapping("/bsArea")
public class BsAreaController {

    @Autowired
    private IBsAreaService iBsAreaService;

    @GetMapping("getById/{areaId}")
    public BsArea getById(@PathVariable(value = "areaId") Integer areaId) {
        return iBsAreaService.getById(areaId);
    }

}

