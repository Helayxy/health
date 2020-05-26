package com.itheima.service;

import com.itheima.entity.Result;

import java.util.Map;

/**
 * 体检预约服务接口
 *
 * @author Helay
 * @date 2020/2/11 20:19
 */
public interface OrderService {

    //提交预约信息
    Result submitOrder(Map map) throws Exception;

    //根据预约id查询预约信息
    Map findById(Integer id) throws Exception;
}
