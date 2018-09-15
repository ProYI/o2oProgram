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

 * 〈〉

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
        return "/shop/shopoperation";
    }

    @RequestMapping(value = "/shoplist")
    public String shopList() {
        return "/shop/shoplist";
    }

    @RequestMapping(value = "/shopmanagement")
    public String shopManagement() {
        return "/shop/shopmanagement";
    }
}
