/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: AreaServiceImpl
 * Author: Administrator
 * Date: 2018-09-07 23:38
 * Description: AreaService实现类
 * History:
 * <author>      <time>      <version>   <desc>
 * <p>
 * 作者姓名      修改时间       版本号      描述
 */


package org.test.o2o.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.o2o.dao.AreaDao;
import org.test.o2o.entity.Area;
import org.test.o2o.service.AreaService;

import java.util.List;

/**

 * 〈功能简述〉<br>

 * 〈AreaService实现类〉

 *

 * @author Administrator

 * @create 2018-09-07

 * @since 1.0.0

 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}