package com.wjc.banner.controller;

import com.wjc.banner.service.BannerService;
import com.wjc.commons.result.lzjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    /**
     * 查询Banner列表
     *
     * @return
     */
    @GetMapping("")
    public lzjResult selectBannerList() {
        return bannerService.selectBannerList();
    }
}