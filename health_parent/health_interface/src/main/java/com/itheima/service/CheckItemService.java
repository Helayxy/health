package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

import java.util.List;

/**
 * 检查项服务接口
 *
 * @author Helay
 * @date 2020/1/18 20:07
 */
public interface CheckItemService {

    //新增检查项
    void add(CheckItem checkItem);

    //分页查询检查项
    PageResult findPage(QueryPageBean queryPageBean);

    //删除检查项
    void deleteById(Integer id);

    //修改检查项
    void edit(CheckItem checkItem);

    //根据id查询检查项
    CheckItem findById(Integer id);

    //查询所有检查项
    List<CheckItem> findAll();
}
