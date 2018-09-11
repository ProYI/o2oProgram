package org.test.o2o.service;

import org.test.o2o.dto.ShopExecution;
import org.test.o2o.entity.Shop;

import java.io.File;
import java.io.InputStream;

public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);
}
