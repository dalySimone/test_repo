package com.zx.entity;

//         `oid` varchar(32) NOT NULL,
//         `ordertime` datetime DEFAULT NULL,
//         `total` double DEFAULT NULL,
//         `name` varchar(20) DEFAULT NULL,
//         `telephone` varchar(20) DEFAULT NULL,
//         `address` varchar(30) DEFAULT NULL,
//         `state` int(11) DEFAULT NULL,
//         `uid` varchar(32) DEFAULT NULL,

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private String oid; //订单编号
    private String ordertime; // 下单时间
    private double tatal; // 下单总金额
    private String name; // 收货人姓名
    private String telephone; //收货人电话
    private String address; // 收货人地址
    private int state; //下单时间
    private String uid; //外键
    private User user; //用来保存订单的用户信息

    List<OrderItem> list = new ArrayList<>();

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public double getTatal() {
        return tatal;
    }

    public void setTatal(double tatal) {
        this.tatal = tatal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid='" + oid + '\'' +
                ", ordertime='" + ordertime + '\'' +
                ", tatal=" + tatal +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", uid='" + uid + '\'' +
                '}';
    }
}
