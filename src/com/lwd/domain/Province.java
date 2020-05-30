package com.lwd.domain;

public class Province {

    private Integer Id;

    private String Name;

    private Integer orderid;

    public Province(Integer id, String name, Integer orderid) {
        Id = id;
        Name = name;
        this.orderid = orderid;
    }

    public Province() {
    }

    @Override
    public String toString() {
        return "Province{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", orderid=" + orderid +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
}
