package com.lwd.dao;

import com.lwd.dao.DistrictDao;
import com.lwd.domain.District;
import com.lwd.utils.DataUtils;

import java.util.List;

public class DistrictDaoImpl implements DistrictDao {

    /**
     *   根据城市id查询地区
     * @param cityId
     * @return
     */
    @Override
    public List<District> getDistrictByCityId(Integer cityId) {

        List<District> districts = null;

        String sql = "SELECT Id,Name FROM district WHERE CityId = ? ";

        try {
            districts = DataUtils.executeDQL(District.class,sql,cityId);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return districts;
    }
}
