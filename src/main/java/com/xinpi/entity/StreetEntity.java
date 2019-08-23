package com.xinpi.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 类 名 称：StreetEntity
 * 类 描 述：TODO
 * 创建时间：2019-08-19 14:56
 * 创 建 人：renhao
 */
@Data
@TableName("street")
public class StreetEntity implements Serializable {
    @TableId
    private Integer id;
    private  String code;
    private  String name;
    private  String areaCode;
    private  String provinceCode;
    private  String cityCode;


}
