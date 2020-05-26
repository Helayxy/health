package com.itheima.dao;

import com.itheima.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 预约设置持久层接口
 *
 * @author Helay
 * @date 2020/2/3 21:33
 */
public interface OrderSettingDao {

    //新增预约设置信息
    void add(OrderSetting orderSetting);

    //根据预约日期更新预约人数
    void editNumberByOrderDate(OrderSetting orderSetting);

    //根据预约日期查询预约总数
    long findCountByOrderDate(Date orderDate);

    //根据日期范围查询预约设置数据
    List<OrderSetting> getOrderSettingByMonth(Map<String, String> map);

    //根据日期查询预约设置信息
    OrderSetting findByOrderDate(Date date);

    //更新已预约人数
    void editReservationsByOrderDate(OrderSetting orderSetting);
}
