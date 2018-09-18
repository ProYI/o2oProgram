/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProductServiceImp
 * Author: Administrator
 * Date: 2018-09-18 12:09
 * Description: 商品相关业务
 * History:
 * <author>      <time>      <version>   <desc>
 * <p>
 * 作者姓名      修改时间       版本号      描述
 */


package org.test.o2o.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.o2o.dao.ProductDao;
import org.test.o2o.dao.ProductImgDao;
import org.test.o2o.dto.ImageHolder;
import org.test.o2o.dto.ProductExecution;
import org.test.o2o.entity.Product;
import org.test.o2o.entity.ProductImg;
import org.test.o2o.enums.ProductStateEnum;
import org.test.o2o.exceptions.ProductOperationException;
import org.test.o2o.service.ProductService;
import org.test.o2o.util.ImageUtil;
import org.test.o2o.util.PathUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**

 * 〈功能简述〉<br>

 * 〈商品相关业务〉

 *

 * @author Administrator

 * @create 2018-09-18

 * @since 1.0.0

 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductImgDao productImgDao;

    /**
     * 添加商品步骤：
     * 1.处理缩略图,获取缩略图相对路径并赋值给product
     * 2.往tb_product写入商品信息,获取productId
     * 3.结合productId批量处理商品详情图
     * 4.将商品详情图列表批量插入tb_product_img中
     * @param product
     * @param imageHolder //缩略图
     * @param imageHolderList //详情图列表
     * @return
     * @throws ProductOperationException
     * */
    @Override
    @Transactional
    public ProductExecution addProduct(Product product, ImageHolder imageHolder, List<ImageHolder> imageHolderList) throws ProductOperationException {
        //空值判断
        if(product!=null && product.getShop() !=null && product.getShop().getShopId()!=null){
            //给商品设置上默认属性
            product.setCreateTime(new Date());
            product.setLastEditTime(new Date());
            //默认为上架状态
            product.setEnableStatus(1);
            //若商品缩略图不为空则添加
            if(imageHolder!=null){
                addThumbnail(product,imageHolder);
            }
            try {
                //创建商品
                int effectedNum=productDao.insertProduct(product);
                if(effectedNum<=0){
                    throw new ProductOperationException("创建商品失败");
                }
            }catch (Exception e){
                throw new ProductOperationException("创建商品失败:"+e.toString());
            }
            //若商品详情图不为空则添加
            if(imageHolderList!=null &&imageHolderList.size()>0){
                addProductImgList(product,imageHolderList);
            }
            return new ProductExecution(ProductStateEnum.SUCCESS,product);
        }else{
            //传入为空则返回空值错误信息
            return new ProductExecution(ProductStateEnum.EMPTY);
        }
    }

    /**
     * 批量添加图片
     * @param product
     * @param imageHolderList
     */
    private void addProductImgList(Product product, List<ImageHolder> imageHolderList) throws ProductOperationException {
        //获取图片存储路径,这里直接存放到相应店铺的文件夹下
        String targetAddr = PathUtil.getShopImagePath(product.getShop().getShopId());
        List<ProductImg> productImgList=new ArrayList<>();

        //遍历图片一次去处理,并添加进productImg实体类里
        for(ImageHolder productImgHolder:imageHolderList){
            String imgAddr = ImageUtil.generateNormalImg(productImgHolder,targetAddr);
            ProductImg prodcutImg = new ProductImg();
            prodcutImg.setImgAddr(imgAddr);
            prodcutImg.setProductId(product.getProductId());
            prodcutImg.setCreateTime(new Date());
            productImgList.add(prodcutImg);
        }
        //如果确实是有图片需要添加的,就执行批量添加操作
        if(productImgList.size()>0){
            try{
                int effectedNum=productImgDao.batchInsertProductImg(productImgList);
                if(effectedNum<=0){
                    throw new ProductOperationException("创建商品详情图片失败");
                }
            }catch (Exception e){
                throw new ProductOperationException("创建商品详情图片失败"+e.toString());
            }
        }
    }

    /**
     * 添加缩略图
     * @param product
     * @param imageHolder
     */
    private void addThumbnail(Product product,ImageHolder imageHolder){
        String dest= PathUtil.getShopImagePath(product.getShop().getShopId());
        String thumbnailAddr= ImageUtil.generateThumbnail(imageHolder,dest);
        product.setImgAddr(thumbnailAddr);
    }
}