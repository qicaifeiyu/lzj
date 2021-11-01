package com.wjc.banner.dao.impl;

import com.wjc.banner.dao.BannerDao;
import com.wjc.pojo.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Banner 服务数据层
 */
@Repository
public class BannerDaoImpl implements BannerDao {

    // 注入 MongoDB 模板对象
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询 Banner 集合
     *
     * @return
     */


    @Override
    public List<Banner> selectBannerList(Query query) {
        return mongoTemplate.find(query, Banner.class);
    }

}