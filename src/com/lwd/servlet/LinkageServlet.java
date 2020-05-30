package com.lwd.servlet;

import com.lwd.domain.City;
import com.lwd.domain.District;
import com.lwd.domain.Province;
import com.lwd.service.CityService;
import com.lwd.service.DistrictService;
import com.lwd.service.ProviceService;
import com.lwd.service.serviceImpl.CityServiceImpl;
import com.lwd.service.serviceImpl.DistrictServiceImpl;
import com.lwd.service.serviceImpl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(value = "/linkage",name = "LinkageServlet")
public class LinkageServlet extends BaseServlet {

    private ProviceService proviceService = new ProvinceServiceImpl();
    private CityService cityService = new CityServiceImpl();
    private DistrictService districtService = new DistrictServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String methodName = req.getParameter("method");

        try {
            //获取一个方法名
            Method method = LinkageServlet.class.getDeclaredMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class);

            //调用当前对象的方法
            method.invoke(this,req,resp);//当前对象调用，方法名为 getProvince(HttpServletRequest req, HttpServletResponse resp)

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void getProvince(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获得所有省份
        List<Province> province = proviceService.getProvince();

        sendJson(province,resp);

    }

    private void getCity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer provinceId = Integer.valueOf(req.getParameter("provinceId"));

        //获得所属省份的所有城市
        List<City> cities = cityService.getCityByProvinceId(provinceId);

        sendJson(cities,resp);
    }

    private void getDistrict(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer cityId = Integer.valueOf(req.getParameter("cityId"));

        //获得所属城市的所有地区
        List<District> districts = districtService.getDistrictByCityId(cityId);
        System.out.println(districts);

        sendJson(districts,resp);
    }


}
