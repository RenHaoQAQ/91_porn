package com.xinpi.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 类 名 称：AreaEntity
 * 类 描 述：TODO
 * 创建时间：2019-08-15 09:36
 * 创 建 人：renhao
 */
@Data
@TableName("area")
public class AreaEntity implements Serializable {
    @TableId
    private Integer id;
    private String code;
    private String name;
    private String cityCode;
    private String provinceCode;
    private String location;
}
