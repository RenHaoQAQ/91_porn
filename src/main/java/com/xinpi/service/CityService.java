package com.xinpi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xinpi.entity.AreaEntity;
import com.xinpi.entity.CityEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类 名 称：CityService
 * 类 描 述：TODO
 * 创建时间：2019-08-16 09:32
 * 创 建 人：renhao
 */
public interface CityService extends IService<CityEntity> {
    List<CityEntity> selectAll();
    void updateLocation(@Param("code")String code, @Param("location")String location);

}
