/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ImageUtil
 * Author: Administrator
 * Date: 2018-09-10 11:29
 * Description: 图片处理工具类
 * History:
 * <author>      <time>      <version>   <desc>
 * <p>
 * 作者姓名      修改时间       版本号      描述
 */


package org.test.o2o.util;


import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**

 * 〈功能简述〉<br>

 * 〈图片处理工具类〉

 *

 * @author Administrator

 * @create 2018-09-10

 * @since 1.0.0

 */

public class ImageUtil {
    public static void main(String[] args) throws IOException {
        //处理图片及水印测试

        Thumbnails.of(new File("D:/test1.jpg")).size(768,500)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("D:/logo.gif")), 0.25f)
                .outputQuality(0.8f).toFile("D:/testNew.jpg");
    }

    //处理店铺门面照和商品小图
    /*
    处理用户传送过来的文件流，直接调用spring自带的文件处理对象CommonsMultipartFile
    targetAddr图片存储位置
     */
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    private static Logger logger= LoggerFactory.getLogger(ImageUtil.class);

    public static String generateThumbnail(InputStream thumbnailInputStream, String targetAddr, String fileName) {
        String realFileName = getRandomFileName();
        String extension = getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("current relativeAddr is:"+relativeAddr);
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current complete addr is:"+PathUtil.getImgBasePath()+relativeAddr);
        try {
            Thumbnails.of(thumbnailInputStream).size(200, 200).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "watermark.png")), 0.25f).outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            throw new RuntimeException("创建缩略图失败：" + e.toString());
        }
        return relativeAddr;
    }

    /*
    创建目标路径所涉及到的目录，即/home/work/o2o/xxx.jpg
    那么home、work、o2o三个文件夹都得自动创建
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }
    /*
    删除文件或目录下文件
    @param storePath:文件路径或者目录路径
     */
    public static void deleteFileOrPath(String storePath) {
        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        //存在
        if(fileOrPath.exists()) {
            //如果是目录
            if (fileOrPath.isDirectory()) {
                File[] files = fileOrPath.listFiles();
                for (int i=0; i<files.length; i++) {
                    files[i].delete();
                }
            }
            //删除文件或者文件夹
            fileOrPath.delete();
        }
    }

    /*
    获取输入文件流的扩展名
     */
    private static String getFileExtension(String fileName) {
        //得到上传时的文件名
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /*
    生成随机文件名，当前年月日时分秒 + 五位随机数
     */
    public static String getRandomFileName() {
        //获取随机的  五位数，取值范围为10000~99999
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }
}