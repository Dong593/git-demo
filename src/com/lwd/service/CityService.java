package com.lwd.service;

import com.lwd.domain.City;

import java.util.List;

public interface CityService {
    //根据省份id查询城市
    List<City> getCityByProvinceId(Integer provinceId);
}
