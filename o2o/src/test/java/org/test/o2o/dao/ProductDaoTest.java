/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProductDaoTest
 * Author: Administrator
 * Date: 2018-09-17 21:03
 * Description: 商品详情测试
 * History:
 * <author>      <time>      <version>   <desc>
 * <p>
 * 作者姓名      修改时间       版本号      描述
 */


package org.test.o2o.dao;


import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.test.o2o.BaseTest;
import org.test.o2o.entity.Product;
import org.test.o2o.entity.ProductCategory;
import org.test.o2o.entity.ProductImg;
import org.test.o2o.entity.Shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**

 * 〈功能简述〉<br>

 * 〈商品详情测试〉

 *

 * @author Administrator

 * @create 2018-09-17

 * @since 1.0.0

 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends BaseTest{
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductImgDao productImgDao;

    @Test
    @Ignore
    public void testAInsertProduct() throws Exception{
        Shop shop1=new Shop();
        shop1.setShopId(1L);
        ProductCategory pc1=new ProductCategory();
        pc1.setProductCategoryId(1L);
        //初始化三个商品实例并添加进shopId为1的店铺里,
        //同时商品类别id也为1
        Product product1=new Product();
        product1.setProductName("测试1");
        product1.setProductDesc("测试Desc1");
        product1.setImgAddr("test1");
        product1.setPriority(1);
        product1.setEnableStatus(1);
        product1.setCreateTime(new Date());
        product1.setLastEditTime(new Date());
        product1.setShop(shop1);
        product1.setProductCategory(pc1);

        Product product2=new Product();
        product2.setProductName("测试2");
        product2.setProductDesc("测试Desc2");
        product2.setImgAddr("test2");
        product2.setPriority(2);
        product2.setEnableStatus(1);
        product2.setCreateTime(new Date());
        product2.setLastEditTime(new Date());
        product2.setShop(shop1);
        product2.setProductCategory(pc1);

        Product product3=new Product();
        product3.setProductName("test3");
        product3.setProductDesc("测试Desc3");
        product3.setImgAddr("test3");
        product3.setPriority(3);
        product3.setEnableStatus(1);
        product3.setCreateTime(new Date());
        product3.setLastEditTime(new Date());
        product3.setShop(shop1);
        product3.setProductCategory(pc1);

        //判断添加是否成功
        int effectedNum=productDao.insertProduct(product1);
        System.out.println(effectedNum);
        effectedNum=productDao.insertProduct(product2);
        System.out.println(effectedNum);
        effectedNum=productDao.insertProduct(product3);
        System.out.println(effectedNum);
    }
}