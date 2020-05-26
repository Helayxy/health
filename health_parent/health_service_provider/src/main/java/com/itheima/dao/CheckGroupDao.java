package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup;

import java.util.List;
import java.util.Map;

/**
 * 检查组持久层接口
 *
 * @author Helay
 * @date 2020/1/21 17:39
 */
public interface CheckGroupDao {

    //新增检查组基本信息
    void add(CheckGroup checkGroup);

    //设置检查组合和检查项的关联关系
    void setCheckGroupAndCheckItem(Map map);

    //分页查询检查组
    Page<CheckGroup> findByCondition(String queryString);

    //根据检查组id查询检查组
    CheckGroup findById(Integer id);

    //根据检查组id查询检查项id集合
    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    //修改检查组基本信息，操作t_checkgroup表
    void edit(CheckGroup checkGroup);

    //删除当前检查组和检查项的关联关系，操作t_checkgroup_checkitem表
    void deleteAssociation(Integer id);

    //查询所有检查组
    List<CheckGroup> findAll();
}
