package com.lwd.service.serviceImpl;

import com.lwd.dao.ProvinceDao;
import com.lwd.dao.ProvinceDaoImpl;
import com.lwd.domain.Province;
import com.lwd.service.ProviceService;

import java.util.List;

public class ProvinceServiceImpl implements ProviceService {

    private ProvinceDao provinceDao = new ProvinceDaoImpl();
    @Override
    public List<Province> getProvince() {
        return provinceDao.getProvince();
    }
}
