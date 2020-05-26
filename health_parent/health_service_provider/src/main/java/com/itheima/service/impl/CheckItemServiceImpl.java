package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 检查项服务接口实现类
 *
 * @author Helay
 * @date 2020/1/18 20:29
 */
@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemDao checkItemDao;

    /**
     * 新增检查项
     *
     * @param checkItem
     */
    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    /**
     * 分页查询检查项
     *
     * @param queryPageBean 查询条件
     * @return
     */
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //使用mybatis框架提供的分页助手插件完成分页
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page<CheckItem> page = checkItemDao.selectByCondition(queryPageBean.getQueryString());
        long total = page.getTotal();//总记录数
        List<CheckItem> rows = page.getResult();//分页结果集
        return new PageResult(total, rows);

    }

    /**
     * 删除检查项
     *
     * @param id 检查项id
     */
    @Override
    public void deleteById(Integer id) {
        //查询当前检查项是否和检查组关联
        long count = checkItemDao.findCountByCheckItemId(id);
        if (count > 0) {
            //当前检查项被引用，不能删除
            throw new RuntimeException("当前检查项被引用，不能删除！");
        }
        checkItemDao.deleteById(id);

    }

    /**
     * 修改检查项
     *
     * @param checkItem 检查项
     * @return
     */
    @Override
    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);

    }

    /**
     * 根据id查询检查项
     *
     * @param id 检查项
     * @return
     */
    @Override
    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }

    /**
     * 查询所有检查项
     *
     * @return
     */
    @Override
    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }
}
