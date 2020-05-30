package com.lwd.service.serviceImpl;

import com.lwd.dao.CityDao;
import com.lwd.dao.CityDaoImpl;
import com.lwd.domain.City;
import com.lwd.service.CityService;

import java.util.List;

public class CityServiceImpl implements CityService {

    private CityDao cityDao = new CityDaoImpl();

    //根据省份id查询城市
    @Override
    public List<City> getCityByProvinceId(Integer provinceId) {
        return cityDao.getCityByProvinceId(provinceId);
    }

}
