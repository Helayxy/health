package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.Setmeal;

import java.util.List;
import java.util.Map;

/**
 * 套餐管理持久层接口
 *
 * @author Helay
 * @date 2020/1/31 15:20
 */
public interface SetmealDao {

    //新增套餐基本信息
    void add(Setmeal setmeal);

    //设置套餐和检查组的多对多关系
    void setSetmealAndCheckGroup(Map<String, Integer> map);

    //分页查询套餐
    Page<Setmeal> findByCondition(String queryString);

    //获取所有套餐信息
    List<Setmeal> findAll();

    //根据套餐id查询套餐详细信息（套餐基本信息、套餐对应的检查组信息、检查组对应的检查项信息）
    Setmeal findById(Integer id);

    //查询套餐占比情况
    List<Map<String,Object>> findSetmealCount();
}
