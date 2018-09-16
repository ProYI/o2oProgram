/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProductCategoryManagementController
 * Author: Administrator
 * Date: 2018-09-16 12:18
 * Description: 商品类别管理controller
 * History:
 * <author>      <time>      <version>   <desc>
 * <p>
 * 作者姓名      修改时间       版本号      描述
 */


package org.test.o2o.web.shopadmin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.test.o2o.dto.Result;
import org.test.o2o.entity.ProductCategory;
import org.test.o2o.entity.Shop;
import org.test.o2o.enums.ProductCategoryStateEnum;
import org.test.o2o.service.ProductCategoryService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**

 * 〈功能简述〉<br>

 * 〈商品类别管理controller〉

 *

 * @author Administrator

 * @create 2018-09-16

 * @since 1.0.0

 */
@Controller
@RequestMapping("/shopadmin")
public class ProductCategoryManagementController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping(value = "/getproductcategorylist", method = RequestMethod.GET)
    @ResponseBody
    private Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request) {

        //Shop shop = new Shop();
        //shop.setShopId(1L);
        //request.getSession().setAttribute("currentShop", shop);
        //因为ShopManagementController的getShopManagementInfo会将shopId设置到session中，因此实际使用中直接从session中可以取到shopId的值

        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
        List<ProductCategory> productCategoryList = null;
        if (currentShop!=null && currentShop.getShopId()>0) {
            productCategoryList = productCategoryService.getProductCategoryList(currentShop.getShopId());
            return new Result<List<ProductCategory>>(true, productCategoryList);
        } else {
            ProductCategoryStateEnum productcategoryStateEnum = ProductCategoryStateEnum.INNER_ERROR;
            return new Result<List<ProductCategory>>(false, productcategoryStateEnum.getState(), productcategoryStateEnum.getStateInfo());
        }

    }
}