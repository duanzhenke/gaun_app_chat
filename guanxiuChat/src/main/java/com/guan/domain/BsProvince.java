package com.guan.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.beans.Transient;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 省份设置
 * </p>
 *
 * @author dzk
 * @since 2020-11-10
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class BsProvince implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增列
     */
    @TableId(value = "PROVINCE_ID", type = IdType.AUTO)
    private Integer provinceId;

    /**
     * 省份代码
     */
    @TableField("PROVINCE_CODE")
    private String provinceCode;

    /**
     * 省份名称
     */
    @TableField("PROVINCE_NAME")
    private String provinceName;

    /**
     * 简称
     */
    @TableField("SHORT_NAME")
    private String shortName;

    /**
     * 经度
     */
    @TableField("LNG")
    private String lng;

    /**
     * 纬度
     */
    @TableField("LAT")
    private String lat;

    /**
     * 排序
     */
    @TableField("SORT")
    private Integer sort;

    /**
     * 创建时间
     */
    @TableField("GMT_CREATE")
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @TableField("GMT_MODIFIED")
    private LocalDateTime gmtModified;

    /**
     * 备注
     */
    @TableField("MEMO")
    private String memo;

    /**
     * 状态
     */
    @TableField("DATA_STATE")
    private Integer dataState;

    /**
     * 租户ID
     */
    @TableField("TENANT_CODE")
    private String tenantCode;

    @TableField(exist = false)
    private List<BsCity> cities;


}
