package com.lwd.dao;

import com.lwd.dao.ProvinceDao;
import com.lwd.domain.City;
import com.lwd.domain.District;
import com.lwd.domain.Province;
import com.lwd.utils.DataUtils;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    /**
     * 查询所有省份
     * @return 所有省份
     */
    @Override
    public List<Province> getProvince() {

        List<Province> province = null;

        //查询所有省份sql
        String sql  = "SELECT Id,Name FROM province";

        try {
            //将查询结果赋值给 province对象
            province = DataUtils.executeDQL(Province.class,sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //返回数据
        return province;
    }



}
