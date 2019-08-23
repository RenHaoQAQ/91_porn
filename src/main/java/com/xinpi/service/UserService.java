package com.xinpi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xinpi.entity.AreaEntity;
import com.xinpi.entity.UserEntity;

/**
 * 类 名 称：UserService
 * 类 描 述：TODO
 * 创建时间：2019-08-06 16:33
 * 创 建 人：renhao
 */
public interface UserService  extends IService<UserEntity> {
    UserEntity findByiphone(String userName);
}
