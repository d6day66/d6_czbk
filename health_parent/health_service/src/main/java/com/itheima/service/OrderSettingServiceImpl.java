package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.OrderSettingDao;
import com.itheima.pojo.OrderSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service(interfaceClass = OrderSettingService.class)
@Transactional
public class OrderSettingServiceImpl implements OrderSettingService {
    @Autowired
    OrderSettingDao orderSettingDao;
    @Override
    public void add(List<String[]> list) {
        ArrayList<OrderSetting> orderSettings = new ArrayList<>();
        if(list!=null){
            for (String[] row : list) {
                String date=row[0];
                String number=row[1];
                orderSettings.add(new OrderSetting(new Date(date),Integer.parseInt(number)));
            }
        }
        for (OrderSetting orderset : orderSettings) {

            Integer integer = orderSettingDao.selectCountByDate(orderset.getOrderDate());
            Date orderDate = orderset.getOrderDate();
            if(integer>0){
                orderSettingDao.editNumByDate(orderset);
            }else {
                orderSettingDao.add(orderset);
            }
        }
    }

    @Override
    public List<Map> getOrderSettingByMonth(String date) {
        String dateBegin = date + "-1";//2019‐3‐1
        String dateEnd = date + "-31";//2019‐3‐31
        Map map = new HashMap();
        map.put("dateBegin",dateBegin);
        map.put("dateEnd",dateEnd);
        List<OrderSetting> list = orderSettingDao.getOrderSettingByMonth(map);
        List<Map> data = new ArrayList<>();
        for (OrderSetting orderSetting : list) {
            Map orderSettingMap = new HashMap();
            orderSettingMap.put("date",orderSetting.getOrderDate().getDate());//获得天数
            orderSettingMap.put("number",orderSetting.getNumber());//可预约人数
            orderSettingMap.put("reservations",orderSetting.getReservations());//
            data.add(orderSettingMap);
        }
        return data;
    }

    @Override
    public void editNumberByDate(OrderSetting orderSetting) {
        Integer count = orderSettingDao.selectCountByDate(orderSetting.getOrderDate());
        if(count>0){
            orderSettingDao.editNumByDate(orderSetting);
        }else {
            orderSettingDao.add(orderSetting);
        }
    }
}
