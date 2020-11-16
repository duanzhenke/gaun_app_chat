package com.guan.mapper;

import com.guan.domain.BsArea;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 地区设置 Mapper 接口
 * </p>
 *
 * @author dzk
 * @since 2020-11-10
 */
@Mapper
public interface BsAreaMapper extends BaseMapper<BsArea> {

}
