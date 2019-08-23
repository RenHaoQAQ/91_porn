package com.xinpi.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 类 名 称：File
 * 类 描 述：TODO
 * 创建时间：2019-08-23 15:24
 * 创 建 人：renhao
 */
@Data
@TableName("city")
public class FileEntity {
    @TableId
    private Integer id;
    private  String fileName;
    private  String filePath;
}
