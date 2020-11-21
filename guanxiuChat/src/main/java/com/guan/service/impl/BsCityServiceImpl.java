package com.guan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guan.domain.BsArea;
import com.guan.domain.BsCity;
import com.guan.domain.BsProvince;
import com.guan.mapper.BsAreaMapper;
import com.guan.mapper.BsCityMapper;
import com.guan.service.IBsCityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 城市设置 服务实现类
 * </p>
 *
 * @author dzk
 * @since 2020-11-10
 */
@Service
public class BsCityServiceImpl extends ServiceImpl<BsCityMapper, BsCity> implements IBsCityService {

    @Resource
    private BsCityMapper cityMapper;

    @Resource
    private BsAreaMapper areaMapper;

    @Override
    public BsCity getCityTree(Integer cityId) {
        BsCity bsCity = cityMapper.selectById(cityId);
        QueryWrapper<BsArea> queryCity = new QueryWrapper<>();
        List<BsArea> areaList = areaMapper.selectList(queryCity.eq("CITY_CODE", bsCity.getCityCode()));
        return bsCity.setAreaList(areaList);
    }
}
