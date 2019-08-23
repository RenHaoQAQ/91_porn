package com.xinpi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 类 名 称：ProvinceEntity
 * 类 描 述：TODO
 * 创建时间：2019-08-14 11:55
 * 创 建 人：renhao
 */
@Data
@TableName("province")

public class ProvinceEntity implements Serializable {
    private Integer id;
    private String code;
    private String name;
    private String location;
}
