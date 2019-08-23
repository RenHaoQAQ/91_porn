package com.xinpi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xinpi.entity.AreaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类 名 称：AreaDao
 * 类 描 述：TODO
 * 创建时间：2019-08-15 09:37
 * 创 建 人：renhao
 */
@Mapper
public interface AreaDao extends BaseMapper<AreaEntity> {
    List<AreaEntity> selectAll();
    void updateLocation(@Param("code")String code, @Param("location")String location);
}
