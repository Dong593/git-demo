package com.lwd.service.serviceImpl;

import com.lwd.dao.DistrictDao;
import com.lwd.dao.DistrictDaoImpl;
import com.lwd.domain.District;
import com.lwd.service.DistrictService;

import java.util.List;

public class DistrictServiceImpl implements DistrictService {

    private DistrictDao districtDao = new DistrictDaoImpl();

    @Override
    public List<District> getDistrictByCityId(Integer cityId) {
        return districtDao.getDistrictByCityId(cityId);
    }
}
