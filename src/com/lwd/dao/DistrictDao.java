package com.lwd.dao;

import com.lwd.domain.District;

import java.util.List;

public interface DistrictDao {

    //根据城市id查询地区
    List<District> getDistrictByCityId(Integer cityId);
}
