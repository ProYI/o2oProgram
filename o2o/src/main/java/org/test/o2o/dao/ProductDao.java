/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProductDao
 * Author: Administrator
 * Date: 2018-09-17 20:13
 * Description: 商品详情
 * History:
 * <author>      <time>      <version>   <desc>
 * <p>
 * 作者姓名      修改时间       版本号      描述
 */


package org.test.o2o.dao;


import org.test.o2o.entity.Product;

/**

 * 〈功能简述〉<br>

 * 〈商品详情〉

 *

 * @author Administrator

 * @create 2018-09-17

 * @since 1.0.0

 */

public interface ProductDao {
    //插入商品
    int insertProduct(Product product);

}