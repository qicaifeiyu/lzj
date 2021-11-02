package service;

import com.wjc.commons.result.lzjResult;

/**
 * 热门推荐服务业务逻辑层
 */
public interface RecommendationService {

    /**
     * 查询商品列表
     * 1. 根据销量倒序查询，获取前 4 个
     * 2. 只能显示 4 个，不足时获取其他城市补足
     *
     * @param city
     * @return
     */
    lzjResult selectRecommendationList(String city);

}