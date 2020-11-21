package com.guan.service;

import com.guan.domain.BsArea;
import com.guan.domain.BsCity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guan.domain.BsProvince;

/**
 * <p>
 * 城市设置 服务类
 * </p>
 *
 * @author dzk
 * @since 2020-11-10
 */
public interface IBsCityService extends IService<BsCity> {

    // 根据城市id  获取区域树
    BsCity getCityTree(Integer cityId);
}
