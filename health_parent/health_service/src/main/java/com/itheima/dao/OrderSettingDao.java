package com.itheima.dao;

import com.itheima.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderSettingDao {
    public void add(OrderSetting orderSetting);

    public Integer selectCountByDate(Date date);

    public void editNumByDate(OrderSetting orderSetting);

    List<OrderSetting> getOrderSettingByMonth(Map date);

    OrderSetting findByOrderDate(Date date);

    void editReservationsByOrderDate(OrderSetting orderSetting);
}
