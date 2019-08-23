package com.xinpi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xinpi.entity.AreaEntity;
import com.xinpi.util.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 类 名 称：AreaService
 * 类 描 述：TODO
 * 创建时间：2019-08-16 09:10
 * 创 建 人：renhao
 */
public interface AreaService  extends IService<AreaEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<AreaEntity> selectAll();
    void updateLocation(@Param("code")String code, @Param("location")String location);

}
