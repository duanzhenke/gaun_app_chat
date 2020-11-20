package com.guan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guan.domain.BsArea;
import com.guan.domain.BsCity;
import com.guan.domain.BsProvince;
import com.guan.mapper.BsAreaMapper;
import com.guan.mapper.BsCityMapper;
import com.guan.mapper.BsProvinceMapper;
import com.guan.service.IBsProvinceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 省份设置 服务实现类
 * </p>
 *
 * @author dzk
 * @since 2020-11-10
 */
@Service
public class BsProvinceServiceImpl extends ServiceImpl<BsProvinceMapper, BsProvince> implements IBsProvinceService {
    @Resource
    private BsCityMapper cityMapper;
    @Resource
    private BsProvinceMapper provinceMapper;

    @Override
    public BsProvince getProvinceTree(Integer provinceId) {
        BsProvince bsProvince = provinceMapper.selectById(provinceId);
        QueryWrapper<BsCity> queryCity = new QueryWrapper<>();
        List<BsCity> cityList = cityMapper.selectList(queryCity.eq("PROVINCE_CODE", bsProvince.getProvinceCode()));

        /*for (BsCity bsCity : cityList) {
            String cityCode = bsCity.getCityCode();
            QueryWrapper<BsArea> queryArea= new QueryWrapper<>();
            List<BsArea> bsAreas = areaMapper.selectList(queryArea.eq("CITY_CODE", cityCode));

        }*/

        return bsProvince.setCities(cityList);
    }
}
