package com.wjc.banner.service.impl;

import com.wjc.banner.dao.BannerDao;
import com.wjc.banner.service.BannerService;
import com.wjc.commons.result.lzjResult;
import com.wjc.pojo.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


    /**
     * Banner 服务业务层
     */
    @Service
    public class BannerServiceImpl implements BannerService {

        @Autowired
        private BannerDao bannerDao;

        @Value("${fastdfs.storage.nginx.prefix:}")
        private String fastStorageNginxPrefix;

        @Override
        public lzjResult selectBannerList() {
            Query query = new Query();
            //按照创建时间倒序，取前6个
            query.with(PageRequest.of(0, 6, Sort.by(Sort.Direction.DESC, "createTime")));
            List<Banner> bannerList = bannerDao.selectBannerList(query);
            if (CollectionUtils.isEmpty(bannerList)) {
                return lzjResult.error();
            }
            //等同于下面写法
            // List<String> imgUrls = new ArrayList<>();
            // for (Banner banner : bannerList) {
            // 	imgUrls.add(banner.getUrl());
            // }
            List<String> imgUrls =
                    bannerList.stream().map(banner -> fastStorageNginxPrefix + banner.getUrl()).collect(Collectors.toList());
            return lzjResult.success("查询成功", imgUrls);
        }
    }