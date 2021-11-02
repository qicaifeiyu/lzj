package com.wjc.hotproduct.service;

import com.wjc.commons.result.lzjResult;

/**
 * 热销商品服务业务逻辑层
 */
public interface HotProductService {

    /**
     * 查询热销商品，根据销量排序，查询条件为城市。获取 4 条数据。
     * 查询的返回结果，热销商品的数量必须是 4 。
     * 查询条件所在城市的热销商品数量大于 4 的时候，只查询销量排序的前 4 位商品。
     * 如果条件所在城市的热销商品数量小于 4 的时候，从其他的城市热销商品中查询销量排序考前的补足。
     *
     * @param city
     * @return
     */
    lzjResult selectHotProductList(String city);

}