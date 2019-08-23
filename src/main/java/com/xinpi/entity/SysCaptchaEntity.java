package com.xinpi.entity;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * 类 名 称：SysCaptchaEntity
 * 类 描 述：TODO
 * 创建时间：2019-08-06 09:53
 * 创 建 人：renhao
 */
@Data
public class SysCaptchaEntity {
    private String uuid;
    /**
     * 验证码
     */
    private String code;
    /**
     * 过期时间
     */
    private Date expireTime;
}
