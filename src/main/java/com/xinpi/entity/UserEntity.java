package com.xinpi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 类 名 称：User
 * 类 描 述：TODO
 * 创建时间：2019-08-02 17:07
 * 创 建 人：renhao
 */

@Data
@TableName("user")
public class UserEntity  implements Serializable {
    private static final long serialVersionUID = -5440372534300871944L;
    private Integer id;
    private String userName;
    private String email;
    private String iphone;
    private String password;
    private Date createTime;
    private String status;
    private String salt;
//    private Boolean rememberMe;
}
