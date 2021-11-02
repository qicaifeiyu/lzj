package com.wjc.hotproduct.dao;

import com.wjc.pojo.Item;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * 热销商品服务数据层
 */
public interface HotProductDao {

    /**
     * 查询热销商品，根据销量排序，查询条件为城市。获取 4 条数据。
     *
     * @param query
     * @return
     */
    List<Item> selectHotProductList(Query query);

}