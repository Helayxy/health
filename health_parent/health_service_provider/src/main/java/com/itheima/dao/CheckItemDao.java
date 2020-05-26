package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;

import java.util.List;

/**
 * 检查项持久层接口
 *
 * @author Helay
 * @date 2020/1/18 20:33
 */
public interface CheckItemDao {

    //新增检查项
    void add(CheckItem checkItem);

    //分页查询检查项
    Page<CheckItem> selectByCondition(String queryString);

    //查询当前检查项是否和检查组关联
    long findCountByCheckItemId(Integer checkItemId);

    //删除检查项
    void deleteById(Integer id);

    //修改检查项
    void edit(CheckItem checkItem);

    //根据id查询检查项
    CheckItem findById(Integer id);

    //查询所有检查项
    List<CheckItem> findAll();
}
