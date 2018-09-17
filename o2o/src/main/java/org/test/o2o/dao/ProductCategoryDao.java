package org.test.o2o.dao;

import org.test.o2o.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {
    /**
    * 功能描述:
    *〈通过shopId查询店铺商品类别〉
    * @param: long shopId
    * @return:List<ProductCategory>
    * @since: 1.0.0
    * @Date: 2018-09-16 11:40
    */
    List<ProductCategory> queryProductCategoryList(long shopId);
    
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);
}
