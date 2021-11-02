package dao;

import com.wjc.pojo.Item;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * 热门推荐服务数据层
 */
public interface RecommendationDao {

    /**
     * 查询商品列表
     *
     * @param query
     * @return
     */
    List<Item> selectRecommendationList(Query query);

}