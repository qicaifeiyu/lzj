package com.wjc.hotproduct.service.impl;

import com.wjc.commons.result.lzjResult;
import com.wjc.hotproduct.dao.HotProductDao;
import com.wjc.hotproduct.service.HotProductService;
import com.wjc.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 热销商品服务业务逻辑层
 */
@Service
public class HotProductServiceImpl implements HotProductService {

    @Autowired
    private HotProductDao itemDao;

    @Value("${fastdfs.storage.nginx.prefix:}")
    private String fastdfsStorageNginxPrefix;

    /**
     * 查询热销商品，根据销量排序，查询条件为城市。获取 4 条数据。
     * 查询的返回结果，热销商品的数量必须是 4 。
     * 查询条件所在城市的热销商品数量大于 4 的时候，只查询销量排序的前 4 位商品。
     * 如果条件所在城市的热销商品数量小于 4 的时候，从其他的城市热销商品中查询销量排序考前的补足。
     *
     * @param city
     * @return
     */
    @Override
    public lzjResult selectHotProductList(String city) {
        // 查询热销商品
        Query query = new Query();
        // 查询条件
        query.addCriteria(Criteria.where("city").is(city));
        // 排序和分页
        query.with(
                PageRequest.of(0, 4,
                        Sort.by(Sort.Direction.DESC, "sales"))
        );
        List<Item> itemList = itemDao.selectHotProductList(query);

        if (itemList.size() < 4) {
            // 查询的热销商品数量不足，需要查询其他城市的热销商品，填充到当前查询结果
            Query otherQuery = new Query();
            // 查询条件， 查询当前城市以外的其他城市热销商品，避免重复数据。
            otherQuery.addCriteria(Criteria.where("city").ne(city));
            // 排序和分页
            otherQuery.with(
                    PageRequest.of(0, 4 - itemList.size(),
                            Sort.by(Sort.Direction.DESC, "sales"))
            );
            List<Item> otherItems = itemDao.selectHotProductList(otherQuery);
            // 将其他城市的热销商品数据，填充到当前城市的热销商品数据集合中。补足 4 条数据。
            itemList.addAll(otherItems);
        }
        // 将图片路径，从相对路径转换为绝对路径。增加 Nginx 地址前缀。
        itemList = changeImgsUrl(itemList);
        return lzjResult.success("查询成功", itemList);
    }

    // 将集合中的每个 Item 类型对象的图片地址，增加前缀。
    private List<Item> changeImgsUrl(List<Item> itemList) {
        for (Item item : itemList) {
            List<String> newImgList = new ArrayList<>();
            for (String img : item.getImgs()) {
                newImgList.add(fastdfsStorageNginxPrefix + img);
            }
            item.setImgs(newImgList);
        }
        return itemList;
    }

}