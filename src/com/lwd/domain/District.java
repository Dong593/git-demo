package com.lwd.domain;

public class District {

    private Integer Id;
    private Integer CityId;
    private String Name;
    private String PostCode;

    public District() {
    }

    public District(Integer id, Integer cityId, String name, String postCode) {
        Id = id;
        CityId = cityId;
        Name = name;
        PostCode = postCode;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getCityId() {
        return CityId;
    }

    public void setCityId(Integer cityId) {
        CityId = cityId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    @Override
    public String toString() {
        return "District{" +
                "Id=" + Id +
                ", CityId=" + CityId +
                ", Name='" + Name + '\'' +
                ", PostCode=" + PostCode +
                '}';
    }
}
