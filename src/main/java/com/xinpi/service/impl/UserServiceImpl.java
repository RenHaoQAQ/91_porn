package com.xinpi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xinpi.dao.ProvinceDao;
import com.xinpi.dao.UserDao;
import com.xinpi.entity.ProvinceEntity;
import com.xinpi.entity.UserEntity;
import com.xinpi.service.ProvinceService;
import com.xinpi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类 名 称：UserServiceImpl
 * 类 描 述：TODO
 * 创建时间：2019-08-06 16:34
 * 创 建 人：renhao
 */
@Service
public class UserServiceImpl  extends ServiceImpl<UserDao, UserEntity> implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity findByiphone(String userName) {
        return userDao.findByiphone(userName);
    }
}
