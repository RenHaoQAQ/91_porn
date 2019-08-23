package com.xinpi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 类 名 称：City
 * 类 描 述：TODO
 * 创建时间：2019-08-14 18:22
 * 创 建 人：renhao
 */
@Data
@TableName("city")

public class CityEntity implements Serializable {
    private  Integer id;
    private  String code;
    private  String name;
    private  String provinceCode;
    private String location;
}
