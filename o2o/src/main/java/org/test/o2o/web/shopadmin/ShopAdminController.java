/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ShopAdminController
 * Author: Administrator
 * Date: 2018-09-11 15:53
 * Description:
 * History:
 * <author>      <time>      <version>   <desc>
 * <p>
 * 作者姓名      修改时间       版本号      描述
 */


package org.test.o2o.web.shopadmin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**

 * 〈功能简述〉<br>

 * 〈视图解析器：解析路由并转发到相应的html中〉

 *

 * @author Administrator

 * @create 2018-09-11

 * @since 1.0.0

 */
@Controller
@RequestMapping(value = "shopadmin", method = {RequestMethod.GET})
public class ShopAdminController {
    @RequestMapping(value = "shopopreation")
    public String shopOperation() {
        //转发至店铺注册/编辑页面
        return "/shop/shopoperation";
    }

    @RequestMapping(value = "/shoplist")
    public String shopList() {
        //转发至店铺列表页面
        return "/shop/shoplist";
    }

    @RequestMapping(value = "/shopmanagement")
    public String shopManagement() {
        //转发至店铺管理页面
        return "/shop/shopmanagement";
    }

    @RequestMapping(value = "/productcategorymanagement")
    public String productCategoryManagement() {
        //转发至商品类别管理页面
        return "/shop/productcategorymanagement";
    }

    @RequestMapping(value = "/productoperation")
    public String productOperation() {
        //转发至商品添加/编辑页面
        return "/shop/productoperation";
    }
}
