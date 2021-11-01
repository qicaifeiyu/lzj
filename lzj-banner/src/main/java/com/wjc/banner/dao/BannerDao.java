package com.wjc.banner.dao;

import com.wjc.pojo.Banner;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * Banner 服务数据层
 */
public interface BannerDao {

    /**
     * 查询 Banner 集合
     *
     * @param query
     * @return
     */
    List<Banner> selectBannerList(Query query);

}