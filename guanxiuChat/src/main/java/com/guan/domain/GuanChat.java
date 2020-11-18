package com.guan.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author dzk
 * @since 2020-11-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GuanChat implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Float id;

    /**
     * 用户名字
     */
    private String userName;

    /**
     * 0 男 1 女
     */
    private Integer gender;

    /**
     * 出生年月日
     */
    private LocalDateTime birthday;

    /**
     * 身高
     */
    private Double userHigh;

    /**
     * 学历
     */
    private String education;

    /**
     * 婚姻状况 0未婚 1 已婚 2 离婚
     */
    private Integer maritalStatus;

    /**
     * 月输入
     */
    private String monthlyIncome;

    /**
     * 电话号码
     */
    private String phoneNumber;

    /**
     * 密码
     */
    private String passWord;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    /**
     * 是否逻辑删除
     */
    private Integer isDelete;


}
