package com.xinpi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xinpi.dao.AreaDao;
import com.xinpi.entity.AreaEntity;
import com.xinpi.service.AreaService;
import com.xinpi.util.PageUtils;
import com.xinpi.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 类 名 称：AreaServiceImpl
 * 类 描 述：TODO
 * 创建时间：2019-08-16 09:11
 * 创 建 人：renhao
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaDao, AreaEntity> implements AreaService {
    @Autowired
    private AreaDao areaDao;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {


        IPage<AreaEntity> page = this.page(
                new Query<AreaEntity>().getPage(params)
//                new QueryWrapper<AreaEntity>()

        );

        return new PageUtils(page);
    }

    @Override
    public List<AreaEntity> selectAll() {
        return areaDao.selectAll();
    }

    @Override
    public void updateLocation(String code, String location) {
        areaDao.updateLocation(code, location);
    }
}
