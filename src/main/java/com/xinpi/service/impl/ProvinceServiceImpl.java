package com.xinpi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xinpi.dao.ProvinceDao;
import com.xinpi.entity.ProvinceEntity;
import com.xinpi.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类 名 称：ProvinceServiceImpl
 * 类 描 述：TODO
 * 创建时间：2019-08-16 09:36
 * 创 建 人：renhao
 */
@Service
public class ProvinceServiceImpl  extends ServiceImpl<ProvinceDao, ProvinceEntity> implements ProvinceService{
    @Autowired
    private ProvinceDao provinceDao;
    @Override
    public void updateLocation(String code, String location) {
        provinceDao.updateLocation(code,location);
    }

    @Override
    public List<ProvinceEntity> selectAll() {
        return provinceDao.selectAll();
    }

    @Override
    public ProvinceEntity queryByCode(String provinceCode) {
        return provinceDao.queryByCode(provinceCode);
    }
}
