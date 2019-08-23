package com.xinpi.service.impl;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.Producer;
import com.xinpi.entity.SysCaptchaEntity;
import com.xinpi.service.SysCaptchaService;
import com.xinpi.util.DateUtils;
import com.xinpi.util.RRException;
import com.xinpi.util.RedisUtils;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 验证码
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service("sysCaptchaService")
public class SysCaptchaServiceImpl  implements SysCaptchaService {
    @Autowired
    private Producer producer;
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        if(StringUtils.isBlank(uuid)){
            throw new RRException("uuid不能为空");
        }
        //生成文字验证码
        String code = producer.createText();

        SysCaptchaEntity captchaEntity = new SysCaptchaEntity();
        captchaEntity.setUuid(uuid);
        captchaEntity.setCode(code);
        captchaEntity.setExpireTime(new Date());
        //5分钟后过期
        Date date = DateUtils.addDateMinutes(new Date(),0);
        System.out.println("date = ====" + date);
        redisUtils.set("captchaEntity"+uuid,captchaEntity,3000);
        return producer.createImage(code);
    }

    @Override
    public boolean validate(String uuid, String code) {
        try {
            String captchaEntity1 = redisUtils.get("captchaEntity"+uuid);
            JSONObject jsonObject = JSON.parseObject(captchaEntity1);
            String expireTime = jsonObject.getString("expireTime");
            Date time =new Date(expireTime);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String timeFormat = sdf.format(time);
            jsonObject.put("expireTime", timeFormat);
            SysCaptchaEntity captchaEntity = JSON.parseObject(jsonObject.toJSONString(), SysCaptchaEntity.class);
            if (captchaEntity == null) {
                return false;
            }
            //删除验证码
            redisUtils.delete("captchaEntity"+uuid);
            if (captchaEntity.getCode().equalsIgnoreCase(code)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
