package com.xinpi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xinpi.entity.AreaEntity;
import com.xinpi.entity.CityEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 类 名 称：CityDao
 * 类 描 述：TODO
 * 创建时间：2019-08-14 18:25
 * 创 建 人：renhao
 */
@Mapper
public interface CityDao extends BaseMapper<CityEntity> {
    List<CityEntity> selectAll();
    void updateLocation(@Param("code")String code, @Param("location")String location);

}
