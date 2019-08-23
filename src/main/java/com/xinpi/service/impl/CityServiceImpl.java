package com.xinpi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xinpi.dao.AreaDao;
import com.xinpi.dao.CityDao;
import com.xinpi.dao.ProvinceDao;
import com.xinpi.entity.AreaEntity;
import com.xinpi.entity.CityEntity;
import com.xinpi.entity.ProvinceEntity;
import com.xinpi.service.AreaService;
import com.xinpi.service.CityService;
import com.xinpi.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类 名 称：AreaServiceImpl
 * 类 描 述：TODO
 * 创建时间：2019-08-16 09:11
 * 创 建 人：renhao
 */
@Service
public class CityServiceImpl  extends ServiceImpl<CityDao, CityEntity> implements CityService {
    @Autowired
    private CityDao cityDao;


    @Override
    public List<CityEntity> selectAll() {
        return cityDao.selectAll();
    }

    @Override
    public void updateLocation(String code, String location) {
        cityDao.updateLocation(code,location);
    }
}
