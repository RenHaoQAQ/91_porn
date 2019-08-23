package com.xinpi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xinpi.entity.CityEntity;
import com.xinpi.entity.ProvinceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类 名 称：ProvinceDao
 * 类 描 述：TODO
 * 创建时间：2019-08-14 11:58
 * 创 建 人：renhao
 */
@Mapper
public interface ProvinceDao extends BaseMapper<ProvinceEntity> {
    void updateLocation(@Param("code")String code,@Param("location")String location);
    List<ProvinceEntity> selectAll();
    ProvinceEntity queryByCode(@Param("provinceCode")String provinceCode);
}
