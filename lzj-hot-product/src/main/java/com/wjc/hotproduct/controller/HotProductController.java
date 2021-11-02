package com.wjc.hotproduct.controller;

import com.wjc.commons.result.lzjResult;
import com.wjc.hotproduct.service.HotProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 热销商品服务控制层
 */
@RestController
@RequestMapping("/hotProduct")
public class HotProductController {

    @Autowired
    private HotProductService itemService;

    /**
     * 查询热销商品，根据销量排序，查询条件为城市。获取 4 条数据。
     *
     * @param city
     * @return
     */
    @GetMapping("")
    public lzjResult selectHotProductList(String city) {
        return itemService.selectHotProductList(city);
    }

}