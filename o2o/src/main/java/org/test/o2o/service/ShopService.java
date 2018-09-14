package org.test.o2o.service;

import org.test.o2o.dto.ShopExecution;
import org.test.o2o.entity.Shop;
import org.test.o2o.exceptions.ShopOperationException;

import java.io.File;
import java.io.InputStream;

public interface ShopService {
    //注册店铺信息，包括图片处理
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);

    //通过店铺Id获取店铺信息
    Shop getByShopId(long shopId);

    //更新店铺信息，包括对图片的处理
    ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
