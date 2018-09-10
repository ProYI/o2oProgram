package org.test.o2o.service;

import org.springframework.web.multipart.MultipartFile;
import org.test.o2o.dto.ShopExecution;
import org.test.o2o.entity.Shop;

public interface ShopService {
    ShopExecution addShop(Shop shop, MultipartFile shopImg);
}
