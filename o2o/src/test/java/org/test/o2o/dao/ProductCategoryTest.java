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

import java.util.ArrayList;
import java.util.Date;
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

    @Test
    public void testBatchInsertProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("ut测试分类1");
        productCategory.setPriority(1);
        productCategory.setCreateTime(new Date());
        productCategory.setShopId(1L);
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setProductCategoryName("ut测试分类2");
        productCategory2.setPriority(2);
        productCategory2.setCreateTime(new Date());
        productCategory2.setShopId(1L);
        List<ProductCategory> productCategoryList=new ArrayList<>();
        productCategoryList.add(productCategory);
        productCategoryList.add(productCategory2);
        int effectedNum=productCategoryDao.batchInsertProductCategory(productCategoryList);
        System.out.println(effectedNum);
    }
}