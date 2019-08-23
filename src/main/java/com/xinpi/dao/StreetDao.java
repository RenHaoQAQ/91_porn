package com.xinpi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xinpi.entity.CityEntity;
import com.xinpi.entity.StreetEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类 名 称：StreetDao
 * 类 描 述：TODO
 * 创建时间：2019-08-19 14:59
 * 创 建 人：renhao
 */
@Mapper
public interface StreetDao extends BaseMapper<StreetEntity> {
    List<StreetEntity> selectAll();

    List<StreetEntity> selectByParams(StreetEntity streetEntity);


}
