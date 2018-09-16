/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProductCategoryTest
 * Author: Administrator
 * Date: 2018-09-16 11:57
 * Description: 商品类别测试类
 * History:
 * <author>      <time>      <version>   <desc>
 * <p>
 * 作者姓名      修改时间       版本号      描述
 */


package org.test.o2o.dao;


import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.test.o2o.BaseTest;
import org.test.o2o.entity.ProductCategory;
import org.test.o2o.entity.Shop;

import java.util.List;

/**

 * 〈功能简述〉<br>

 * 〈商品类别测试类〉

 *

 * @author Administrator

 * @create 2018-09-16

 * @since 1.0.0

 */

public class ProductCategoryTest extends BaseTest {
    @Autowired
    ProductCategoryDao productCategoryDao;

    @Test
    @Ignore
    public void testQueryProductCategoryList() {
        long shopId = 1;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println("该店铺自定义类别数为：" + productCategoryList.size());
    }
}