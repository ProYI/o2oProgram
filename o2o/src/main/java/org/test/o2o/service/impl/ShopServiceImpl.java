/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ShopServiceImpl
 * Author: Administrator
 * Date: 2018-09-11 0:14
 * Description: 店铺Service
 * History:
 * <author>      <time>      <version>   <desc>
 * <p>
 * 作者姓名      修改时间       版本号      描述
 */


package org.test.o2o.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.test.o2o.dao.ShopDao;
import org.test.o2o.dto.ShopExecution;
import org.test.o2o.entity.Shop;
import org.test.o2o.enums.ShopStateEnum;
import org.test.o2o.exceptions.ShopOperationException;
import org.test.o2o.service.ShopService;
import org.test.o2o.util.ImageUtil;
import org.test.o2o.util.PathUtil;

import java.util.Date;

/**

 * 〈功能简述〉<br>

 * 〈店铺Service〉

 *

 * @author Administrator

 * @create 2018-09-11

 * @since 1.0.0

 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Transactional
    public ShopExecution addShop(Shop shop, MultipartFile shopImg) {
        //空值判断
        if(shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            //给店铺信息赋初始值
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <= 0) {
                throw new ShopOperationException("店铺创建失败");
            } else {
                if (shopImg != null) {
                    //存储图片
                    try {
                        addShopImg(shop, shopImg);
                    } catch (Exception e) {
                        throw new ShopOperationException("addShopImg error:" + e.getMessage());
                    }
                    //因为java是值传递，所以更新图片地址后，访问相同对象，都可以访问到地址
                    //更新店铺的图片地址
                    effectedNum = shopDao.updateShop(shop);
                    if (effectedNum <= 0) {
                        throw new ShopOperationException("更新图片地址失败");
                    }

                }
            }
        } catch (Exception e) {
            throw new ShopOperationException("addShop error:" + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    private void addShopImg(Shop shop, MultipartFile shopImg) {
        //获取shop图片目录的相对值路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg, dest);
        //将图片路径存储用于更新店铺信息
        shop.setShopImg(shopImgAddr);
    }
}