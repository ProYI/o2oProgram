/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProductCategoryServiceImpl
 * Author: Administrator
 * Date: 2018-09-16 12:13
 * Description: 商品类别接口实现类
 * History:
 * <author>      <time>      <version>   <desc>
 * <p>
 * 作者姓名      修改时间       版本号      描述
 */


package org.test.o2o.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.o2o.dao.ProductCategoryDao;
import org.test.o2o.entity.ProductCategory;
import org.test.o2o.service.ProductCategoryService;

import java.util.List;

/**

 * 〈功能简述〉<br>

 * 〈商品类别接口实现类〉

 *

 * @author Administrator

 * @create 2018-09-16

 * @since 1.0.0

 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    //查询指定某个店铺下的所有商品类别信息
    @Override
    public List<ProductCategory> getProductCategoryList(long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);
    }
}