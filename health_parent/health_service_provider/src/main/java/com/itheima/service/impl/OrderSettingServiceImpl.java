package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.OrderSettingDao;
import com.itheima.pojo.OrderSetting;
import com.itheima.service.OrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Helay
 * @date 2020/2/3 21:28
 */
@Service(interfaceClass = OrderSettingService.class)
@Transactional
public class OrderSettingServiceImpl implements OrderSettingService {

    @Autowired
    private OrderSettingDao orderSettingDao;

    /**
     * 批量添加预约设置信息
     *
     * @param list
     */
    @Override
    public void add(List<OrderSetting> list) {
        if (list != null && list.size() > 0) {
            for (OrderSetting orderSetting : list) {
                //判断当前日期是否已经进行了预约设置
                long count = orderSettingDao.findCountByOrderDate(orderSetting.getOrderDate());
                if (count > 0) {
                    //已经进行了预约，执行更新操作
                    orderSettingDao.editNumberByOrderDate(orderSetting);
                } else {
                    //没有进行预约设置，执行添加操作‘
                    orderSettingDao.add(orderSetting);
                }
            }
        }
    }

    /**
     * 根据日期查询所在月份的预约设置数据
     *
     * @param date
     * @return
     */
    @Override
    public List<Map> getOrderSettingByMonth(String date) {//参数格式为：2019-3
        String begin = date + "-1";//2019-3-1，每个月的开始日期
        String end = date + "-31";//2019-3-31，每个月的结束日期，每个月都按31天算
        Map<String, String> map = new HashMap<>();//构造一个map，将每个月的开始和结束日期存入map
        map.put("begin", begin);
        map.put("end", end);
        //调用dao，根据日期范围查询预约设置数据
        List<OrderSetting> list = orderSettingDao.getOrderSettingByMonth(map);
        List<Map> result = new ArrayList<>();
        //将从数据库查到的数据转换成页面需要的数据格式
        if (list != null && list.size() > 0) {
            for (OrderSetting orderSetting : list) {
                Map<String, Object> hashMap = new HashMap<>();
                hashMap.put("date", orderSetting.getOrderDate().getDate());//获取日期数字（几号）
                hashMap.put("number", orderSetting.getNumber());
                hashMap.put("reservations", orderSetting.getReservations());
                result.add(hashMap);
            }
        }
        return result;
    }

    /**
     * 根据日期修改可预约人数
     *
     * @param orderSetting
     */
    @Override
    public void editNumberByDate(OrderSetting orderSetting) {
        //判断当前日期是否已经进行了预约设置
        long count = orderSettingDao.findCountByOrderDate(orderSetting.getOrderDate());
        if (count > 0) {
            //已经进行了预约设置，执行更新操作
            orderSettingDao.editNumberByOrderDate(orderSetting);
        } else {
            //没有进行预约设置，执行添加操作
            orderSettingDao.add(orderSetting);
        }
    }
}
