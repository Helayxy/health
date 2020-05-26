package com.itheima.jobs;

import com.itheima.constant.RedisConstant;
import com.itheima.utils.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * 定时任务：清理垃圾图片
 *
 * @author Helay
 * @date 2020/2/2 21:09
 */
public class ClearImgJob {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 清理图片
     */
    public void clearImg() {
        //计算redis中两个集合的差值，获取垃圾图片名称集合
        Set<String> set = jedisPool.getResource().sdiff(RedisConstant.SETMEAL_PIC_RESOURCES, RedisConstant.SETMEAL_PIC_DB_RESOURCES);
        //遍历垃圾图片集合进行删除
        if (set != null) {
            for (String picName : set) {
                //删除七牛云服务器上的图片
                QiniuUtils.deleteFileFromQiniu(picName);
                //删除Redis集合中的图片
                jedisPool.getResource().srem(RedisConstant.SETMEAL_PIC_RESOURCES, picName);

            }
        }
    }

}
