package com.xinpi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xinpi.entity.AreaEntity;
import com.xinpi.entity.ProvinceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类 名 称：ProvinceService
 * 类 描 述：TODO
 * 创建时间：2019-08-16 09:35
 * 创 建 人：renhao
 */
public interface ProvinceService  extends IService<ProvinceEntity> {
    void updateLocation(@Param("code")String code, @Param("location")String location);
    List<ProvinceEntity> selectAll();
    ProvinceEntity queryByCode(@Param("provinceCode")String provinceCode);
}
