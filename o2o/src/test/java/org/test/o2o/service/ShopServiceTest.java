/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ShopServiceTest
 * Author: Administrator
 * Date: 2018-09-11 1:06
 * Description: 店铺service测试类
 * History:
 * <author>      <time>      <version>   <desc>
 * <p>
 * 作者姓名      修改时间       版本号      描述
 */


package org.test.o2o.service;


import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.test.o2o.BaseTest;
import org.test.o2o.dto.ShopExecution;
import org.test.o2o.entity.Area;
import org.test.o2o.entity.PersonInfo;
import org.test.o2o.entity.Shop;
import org.test.o2o.entity.ShopCategory;
import org.test.o2o.enums.ShopStateEnum;

import java.io.*;
import java.util.Date;

import static org.junit.Assert.assertEquals;


/**

 * 〈功能简述〉<br>

 * 〈店铺service测试类〉

 *

 * @author Administrator

 * @create 2018-09-11

 * @since 1.0.0

 */

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    @Ignore
    public void testAddShop() throws IOException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);

        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺3");
        shop.setShopDesc("test3");
        shop.setShopAddr("test3");
        shop.setPhone("test3");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");

        File shopImg = new File("D:\\test1.jpg");
        InputStream inputStream = new FileInputStream(shopImg);

        ShopExecution se = shopService.addShop(shop, inputStream, shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }

    ///*
    //文件流转换为上传流 MultipartFile
    // */
    //private MultipartFile path2MultipartFile(String filePath) throws IOException {
    //    File file = new File(filePath);
    //    FileInputStream input = new FileInputStream(file);
    //    MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain",
    //            IOUtils.toByteArray(input));
    //    return multipartFile;
    //}


}