package com.lwd.dao;

import com.lwd.dao.CityDao;
import com.lwd.domain.City;
import com.lwd.utils.DataUtils;

import java.util.List;

public class CityDaoImpl implements CityDao {
    /**
     * 根据省份id查询城市
     * @param provinceId
     * @return  返回所属城市
     */
    @Override
    public List<City> getCityByProvinceId(Integer provinceId) {

        List<City> cities = null;

        String sql = "SELECT Id,Name FROM city WHERE ProvinceId = ? ";

        try {
            cities = DataUtils.executeDQL(City.class,sql,provinceId);

        }catch (Exception e) {
            e.printStackTrace();
        }

        return cities;
    }

}
