package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.Setmeal;

import java.util.List;
import java.util.Map;

/**
 * 套餐管理服务接口
 *
 * @author Helay
 * @date 2020/1/31 14:54
 */
public interface SetmealService {

    //新增套餐
    void add(Setmeal setmeal, Integer[] checkgroupIds);

    //分页查询套餐
    PageResult pageQuery(QueryPageBean queryPageBean);

    //获取所有套餐信息
    List<Setmeal> findAll();

    //根据套餐id查询套餐详细信息（套餐基本信息、套餐对应的检查组信息、检查组对应的检查项信息）
    Setmeal findById(Integer id);

    //查询套餐占比情况
    List<Map<String, Object>> findSetmealCount();
}
