package com.xinpi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xinpi.entity.CityEntity;
import com.xinpi.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 类 名 称：UserMapper
 * 类 描 述：TODO
 * 创建时间：2019-08-02 17:08
 * 创 建 人：renhao
 */

@Mapper
public interface UserDao  extends BaseMapper<UserEntity> {
    UserEntity findByiphone(String userName);
}