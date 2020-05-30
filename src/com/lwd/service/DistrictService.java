package com.lwd.service;

import com.lwd.domain.City;
import com.lwd.domain.District;
import com.lwd.domain.Province;

import java.util.List;

public interface DistrictService {





    //根据城市id查询地区
    List<District> getDistrictByCityId(Integer cityId);
}
