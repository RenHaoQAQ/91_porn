package com.xinpi;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xinpi.dao.AreaDao;
import com.xinpi.dao.CityDao;
import com.xinpi.dao.ProvinceDao;
import com.xinpi.dao.StreetDao;
import com.xinpi.entity.AreaEntity;
import com.xinpi.entity.CityEntity;
import com.xinpi.entity.ProvinceEntity;
import com.xinpi.entity.StreetEntity;
import com.xinpi.service.AreaService;
import com.xinpi.util.FourRandom;
import com.xinpi.util.PageUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 类 名 称：ProvincialTest
 * 类 描 述：TODO
 * 创建时间：2019-08-14 10:45
 * 创 建 人：renhao
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProvincialTest {
    @Autowired
    private AreaService areaService;
    @Autowired
    private ProvinceDao provinceDao;

    @Autowired
    private CityDao cityDao;
    @Autowired
    private StreetDao streetDao;


    private static final String URL = "https://restapi.amap.com/v3/geocode/geo";

    /*省*/
    @Test
    public void test01() {
        List<ProvinceEntity> provinceEntities = provinceDao.selectAll();
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("key", "a7dfaa225a67b8074998186f17d7dbc8");
        for (int i = 0; i < provinceEntities.size(); i++) {
            ProvinceEntity provinceEntity = provinceEntities.get(i);
            String name = provinceEntity.getName();
//可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
            paramMap.put("address", name);
            String result3 = HttpUtil.get(URL, paramMap);
            JSONObject jsonObject = JSON.parseObject(result3);
            String geocodes = jsonObject.getString("geocodes");
            JSONArray jsonArray = JSON.parseArray(geocodes);
            for (int j = 0; j < jsonArray.size(); j++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(j);
                String location = jsonObject1.getString("location");
                provinceDao.updateLocation(provinceEntity.getCode(), location);
            }
        }

    }

    /*
    市
     */
    @Test
    public void test02() {
        List<CityEntity> cityEntities = cityDao.selectAll();
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("key", "a7dfaa225a67b8074998186f17d7dbc8");
        for (int i = 0; i < cityEntities.size(); i++) {
            CityEntity cityEntity = cityEntities.get(i);
            String name = cityEntity.getName();
//可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
            paramMap.put("address", name);
            String result3 = HttpUtil.get(URL, paramMap);
            JSONObject jsonObject = JSON.parseObject(result3);
            String geocodes = jsonObject.getString("geocodes");
            JSONArray jsonArray = JSON.parseArray(geocodes);
            for (int j = 0; j < jsonArray.size(); j++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(j);
                String location = jsonObject1.getString("location");
                cityDao.updateLocation(cityEntity.getCode(), location);
            }
        }

    }

    /*
     * 县城
     * */
    @Test
    public void test03() {
        List<AreaEntity> areaEntities = areaService.selectAll();

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("key", "a7dfaa225a67b8074998186f17d7dbc8");
        for (int i = 0; i < areaEntities.size(); i++) {
            AreaEntity areaEntity = areaEntities.get(i);
            //省份代码
            String provinceCode = areaEntity.getProvinceCode();
            ProvinceEntity provinceEntity = provinceDao.queryByCode(provinceCode);
            //省份名
            String name = provinceEntity.getName();
            //省份+县名
            paramMap.put("address", name + areaEntity.getName());
            String result3 = HttpUtil.get(URL, paramMap);
            JSONObject jsonObject = JSON.parseObject(result3);
            String geocodes = jsonObject.getString("geocodes");
            JSONArray jsonArray = JSON.parseArray(geocodes);
            for (int j = 0; j < jsonArray.size(); j++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(j);
                String location = jsonObject1.getString("location");
                areaService.updateLocation(areaEntity.getCode(), location);
            }
        }

    }

    @Test
    public void ss() {
        for (int i = 0; i < 1111; i++) {
            String fourRandom = FourRandom.getFourRandom();
            System.out.println("fourRandom ==== " + fourRandom);
        }

    }

    @Test
    public void test05() {
        List<AreaEntity> list = areaService.list();
        System.out.println("list.size() = " + list.size());
        HashMap<String, Object> params = new HashMap<>();
        params.put("city_code", 1101);
        Collection<AreaEntity> areaEntities = areaService.listByMap(params);
        System.out.println("list.size() = " + areaEntities.size());
        QueryWrapper<AreaEntity> areaEntityQueryWrapper = new QueryWrapper<>();
        areaEntityQueryWrapper.like(false, "city_code", 1101);
        List<Object> objects = areaService.listObjs(areaEntityQueryWrapper);
        System.out.println("objects.size() = " + objects.size());
    }

    @Test
    public void te000() {
        StreetEntity streetEntity = new StreetEntity();
        streetEntity.setName("太阳");
        List<StreetEntity> streetEntities = streetDao.selectByParams(streetEntity);
        System.out.println("streetEntities = " + streetEntities);
    }

    @Test
    public void te0001() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("page", "2");
        params.put("limit", "19");
        PageUtils page = areaService.queryPage(params);
        List<?> list = page.getList();
        for (int i = 0; i < list.size(); i++) {
            AreaEntity areaEntity = (AreaEntity) list.get(i);
            areaEntity.getName();
            System.out.println("  ===" + areaEntity.getName());
        }

    }


}
