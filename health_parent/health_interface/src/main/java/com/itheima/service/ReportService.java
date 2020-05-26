package com.itheima.service;

import java.util.Map;

/**
 * @author Helay
 * @date 2020/2/24 19:31
 */
public interface ReportService {

    //获得运营统计数据
    Map<String, Object> getBusinessReport() throws Exception;

}
