package com.wjc;

import com.wjc.mongodb.MongoDBApplication;
import com.wjc.pojo.Banner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = {MongoDBApplication.class})
@ActiveProfiles("mongodb")
public class MongoDBTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void insertBanners() {
        List<Banner> list = new ArrayList<>();

        Banner banner1 = new Banner();
        banner1.setCreateTime(new Date());
        banner1.setUrl("group1/M00/00/00/wKgKZGF6phyABMg8AADZCwsgDr8539.png");

        Banner banner2 = new Banner();
        banner2.setCreateTime(new Date());
        banner2.setUrl("group1/M00/00/00/wKgKZGF6piaAQkE8AADEWJ2H-q8480.png");

        Banner banner3 = new Banner();
        banner3.setCreateTime(new Date());
        banner3.setUrl("group1/M00/00/00/wKgKZGF6piCAUb_hAACj6oiIMnY060.png");

        Banner banner4 = new Banner();
        banner4.setCreateTime(new Date());
        banner4.setUrl("group1/M00/00/00/wKgKZGF6pimALBW3AACUlqaDUJs505.png");

        Banner banner5 = new Banner();
        banner5.setCreateTime(new Date());
        banner5.setUrl("group1/M00/00/00/wKgKZGF6piOAB6FwAADzZuYOH74361.png");

        Banner banner6 = new Banner();
        banner6.setCreateTime(new Date());
        banner6.setUrl("group1/M00/00/00/wKgKZGF6piyAI4CZAACkIflZOdk031.png");

        list.add(banner1);
        list.add(banner2);
        list.add(banner3);
        list.add(banner4);
        list.add(banner5);
        list.add(banner6);

        Collection<Banner> result = mongoTemplate.insert(list, Banner.class);
        System.out.println(result);
    }

}