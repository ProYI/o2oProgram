package org.test.o2o.dao;

import org.test.o2o.entity.Shop;

public interface ShopDao {
    /**
    * 功能描述:
    *〈新增店铺〉
    * * @param shop
    * @return:
    * @since: 1.0.0
    * @Author:Administrator
    * @Date: 2018-09-08 12:53
    */
    int insertShop(Shop shop);

    /**
    * 功能描述:
    *〈更新店铺信息〉
    * @param: shop
    * @return:
    * @since: 1.0.0
    * @Date: 2018-09-10 10:54
    */
    int updateShop(Shop shop);
}
