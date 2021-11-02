package com.wjc.hotproduct.dao.impl;

import com.wjc.hotproduct.dao.HotProductDao;
import com.wjc.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 热销商品服务数据层
 */
@Repository
public class HotProductDaoImpl implements HotProductDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询热销商品，根据销量排序，查询条件为城市。获取 4 条数据。
     *
     * @param query
     * @return
     */
    @Override
    public List<Item> selectHotProductList(Query query) {
        return mongoTemplate.find(query, Item.class);
    }

}