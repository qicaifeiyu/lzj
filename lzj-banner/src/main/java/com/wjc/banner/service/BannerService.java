package com.wjc.banner.service;

import com.wjc.commons.result.lzjResult;

/**
 * Banner 服务业务层
 */
public interface BannerService {

    /**
     * 查询Banner列表
     *
     * @return
     */
    lzjResult selectBannerList();

}