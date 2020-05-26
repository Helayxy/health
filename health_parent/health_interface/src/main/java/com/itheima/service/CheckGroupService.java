package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;

import java.util.List;

/**
 * 检查组服务接口
 *
 * @author Helay
 * @date 2020/1/21 17:16
 */
public interface CheckGroupService {

    //新增检查组（包括基本信息和检查项信息两部分）
    void add(CheckGroup checkGroup, Integer[] checkitemIds);

    //分页查询检查组
    PageResult pageQuery(QueryPageBean queryPageBean);

    //根据检查组id查询检查组
    CheckGroup findById(Integer id);

    //根据检查组id查询检查项id集合
    List<Integer> findCheckItemIdsByCheckGroupId(Integer id);

    //修改检查组（包括基本信息和检查项信息两部分）
    void edit(CheckGroup checkGroup, Integer[] checkitemIds);

    //查询所有检查组
    List<CheckGroup> findAll();
}
