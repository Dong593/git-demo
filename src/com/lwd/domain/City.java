package com.lwd.domain;

public class City {

    private Integer Id;
    private Integer ProvinceId;
    private String Name;
    private String AreaCode;

    public City() {
    }

    public City(Integer id, Integer provinceId, String name, String areaCode) {
        Id = id;
        ProvinceId = provinceId;
        Name = name;
        AreaCode = areaCode;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getProvinceId() {
        return ProvinceId;
    }

    public void setProvinceId(Integer provinceId) {
        ProvinceId = provinceId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(String areaCode) {
        AreaCode = areaCode;
    }

    @Override
    public String toString() {
        return "City{" +
                "Id=" + Id +
                ", ProvinceId=" + ProvinceId +
                ", Name='" + Name + '\'' +
                ", AreaCode='" + AreaCode + '\'' +
                '}';
    }
}
