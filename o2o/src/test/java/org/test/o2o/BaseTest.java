/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: BaseTest
 * Author: Administrator
 * Date: 2018-09-07 23:17
 * Description: 测试类
 * History:
 * <author>      <time>      <version>   <desc>
 * <p>
 * 作者姓名      修改时间       版本号      描述
 */


package org.test.o2o;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**

 * 〈功能简述〉<br>

 * 〈配置spring和junit整合，junit启动时加载springIOC容器〉

 *

 * @author Administrator

 * @create 2018-09-07

 * @since 1.0.0

 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml","classpath:spring/spring-redis.xml"})
public class BaseTest {

}