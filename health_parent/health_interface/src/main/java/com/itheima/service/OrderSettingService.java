package com.itheima.service;

import com.itheima.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

/**
 * 预约设置服务接口
 *
 * @author Helay
 * @date 2020/2/3 21:08
 */
public interface OrderSettingService {

    //批量添加预约设置信息
    void add(List<OrderSetting> list);

    //根据日期查询所在月份的预约设置数据
    List<Map> getOrderSettingByMonth(String date);//参数格式为：2019-3

    //根据日期修改可预约人数
    void editNumberByDate(OrderSetting orderSetting);
}
