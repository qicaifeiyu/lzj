package com.wjc;

import com.wjc.mongodb.MongoDBApplication;
import com.wjc.pojo.Banner;
import com.wjc.pojo.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;

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
        banner1.setUrl("group1/M00/00/00/wKgKZGF6phyABMg8AADZCwsgDr8539.jpg");

        Banner banner2 = new Banner();
        banner2.setCreateTime(new Date());
        banner2.setUrl("group1/M00/00/00/wKgKZGF6piaAQkE8AADEWJ2H-q8480.jpg");

        Banner banner3 = new Banner();
        banner3.setCreateTime(new Date());
        banner3.setUrl("group1/M00/00/00/wKgKZGF6piCAUb_hAACj6oiIMnY060.jpg");

        Banner banner4 = new Banner();
        banner4.setCreateTime(new Date());
        banner4.setUrl("group1/M00/00/00/wKgKZGF6pimALBW3AACUlqaDUJs505.jpg");

        Banner banner5 = new Banner();
        banner5.setCreateTime(new Date());
        banner5.setUrl("group1/M00/00/00/wKgKZGF6piOAB6FwAADzZuYOH74361.jpg");

        Banner banner6 = new Banner();
        banner6.setCreateTime(new Date());
        banner6.setUrl("group1/M00/00/00/wKgKZGF6piyAI4CZAACkIflZOdk031.jpg");

        list.add(banner1);
        list.add(banner2);
        list.add(banner3);
        list.add(banner4);
        list.add(banner5);
        list.add(banner6);

        Collection<Banner> result = mongoTemplate.insert(list, Banner.class);
        System.out.println(result);
    }

    @Test
    public void insertHotProduct() {
        List<Item> items = new ArrayList<>();

        Item item = new Item();
        item.setCity("??????");
        item.setHouseType("150 ???");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGF7bGaAbMeMAADZCwsgDr8471.jpg",
                        "group1/M00/00/00/wKgKZGF7bGuAK0uwAACj6oiIMnY871.jpg",
                        "group1/M00/00/00/wKgKZGF7bG-AFNTcAADzZuYOH74294.jpg"
                )
        );
        item.setPrice(12000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("??????");
        item.setSales(100L);
        item.setTitle("??????????????????");
        Map<String, String> info = new HashMap<>();
        info.put("years", "2010");
        info.put("type", "3???2???");
        info.put("level", "10/18???");
        info.put("style", "?????????");
        info.put("orientation", "????????????");
        item.setInfo(info);
        items.add(item);

        item = new Item();
        item.setCity("??????");
        item.setHouseType("230 ???");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGF7bHOADk23AADEWJ2H-q8967.jpg",
                        "group1/M00/00/00/wKgKZGF7bHeAUo4hAACUlqaDUJs307.jpg",
                        "group1/M00/00/00/wKgKZGF7bHqAekqlAACkIflZOdk269.jpg"
                )
        );
        item.setPrice(21000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 12);
        item.setRentType("??????");
        item.setSales(30L);
        info = new HashMap<>();
        info.put("years", "2007");
        info.put("type", "5???3???");
        info.put("level", "2/2???");
        info.put("style", "?????????");
        info.put("orientation", "????????????");
        item.setInfo(info);
        item.setTitle("??????????????????");
        items.add(item);

        item = new Item();
        item.setCity("??????");
        item.setHouseType("310 ???");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGF7bGaAbMeMAADZCwsgDr8471.jpg",
                        "group1/M00/00/00/wKgKZGF7bGuAK0uwAACj6oiIMnY871.jpg",
                        "group1/M00/00/00/wKgKZGF7bG-AFNTcAADzZuYOH74294.jpg"
                )
        );
        item.setPrice(30000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 6);
        item.setRentType("??????");
        item.setSales(10L);
        info = new HashMap<>();
        info.put("years", "2013");
        info.put("type", "6???4???");
        info.put("level", "3/3???");
        info.put("style", "????????????");
        info.put("orientation", "????????????");
        item.setInfo(info);
        item.setTitle("??????????????????");
        items.add(item);

        item = new Item();
        item.setCity("??????");
        item.setHouseType("60 ???");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGF7bHOADk23AADEWJ2H-q8967.jpg",
                        "group1/M00/00/00/wKgKZGF7bHeAUo4hAACUlqaDUJs307.jpg",
                        "group1/M00/00/00/wKgKZGF7bHqAekqlAACkIflZOdk269.jpg"
                )
        );
        item.setPrice(3000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("??????");
        item.setSales(300L);
        info = new HashMap<>();
        info.put("years", "2000");
        info.put("type", "2???1???");
        info.put("level", "6/6???");
        info.put("style", "????????????");
        info.put("orientation", "??????");
        item.setInfo(info);
        item.setTitle("???????????????");
        items.add(item);

        item = new Item();
        item.setCity("??????");
        item.setHouseType("150 ???");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGF7bGaAbMeMAADZCwsgDr8471.jpg",
                        "group1/M00/00/00/wKgKZGF7bGuAK0uwAACj6oiIMnY871.jpg",
                        "group1/M00/00/00/wKgKZGF7bG-AFNTcAADzZuYOH74294.jpg"
                )
        );
        item.setPrice(12000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("??????");
        item.setSales(100L);
        item.setTitle("??????????????????");
        info = new HashMap<>();
        info.put("years", "2010");
        info.put("type", "3???2???");
        info.put("level", "10/18???");
        info.put("style", "?????????");
        info.put("orientation", "????????????");
        item.setInfo(info);
        items.add(item);

        item = new Item();
        item.setCity("??????");
        item.setHouseType("230 ???");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGF7bHOADk23AADEWJ2H-q8967.jpg",
                        "group1/M00/00/00/wKgKZGF7bHeAUo4hAACUlqaDUJs307.jpg",
                        "group1/M00/00/00/wKgKZGF7bHqAekqlAACkIflZOdk269.jpg"
                )
        );
        item.setPrice(21000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 12);
        item.setRentType("??????");
        item.setSales(30L);
        info = new HashMap<>();
        info.put("years", "2007");
        info.put("type", "5???3???");
        info.put("level", "2/2???");
        info.put("style", "?????????");
        info.put("orientation", "????????????");
        item.setInfo(info);
        item.setTitle("??????????????????");
        items.add(item);

        item = new Item();
        item.setCity("??????");
        item.setHouseType("310 ???");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGF7bGaAbMeMAADZCwsgDr8471.jpg",
                        "group1/M00/00/00/wKgKZGF7bGuAK0uwAACj6oiIMnY871.jpg",
                        "group1/M00/00/00/wKgKZGF7bG-AFNTcAADzZuYOH74294.jpg"
                )
        );
        item.setPrice(30000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 6);
        item.setRentType("??????");
        item.setSales(10L);
        info = new HashMap<>();
        info.put("years", "2013");
        info.put("type", "6???4???");
        info.put("level", "3/3???");
        info.put("style", "????????????");
        info.put("orientation", "????????????");
        item.setInfo(info);
        item.setTitle("??????????????????");
        items.add(item);

        item = new Item();
        item.setCity("??????");
        item.setHouseType("60 ???");
        item.setImgs(
                Arrays.asList(
                        "group1/M00/00/00/wKgKZGF7bHOADk23AADEWJ2H-q8967.jpg",
                        "group1/M00/00/00/wKgKZGF7bHeAUo4hAACUlqaDUJs307.jpg",
                        "group1/M00/00/00/wKgKZGF7bHqAekqlAACkIflZOdk269.jpg"
                )
        );
        item.setPrice(3000L);
        item.setRecommendation(true);
        item.setRecoSort((byte) 9);
        item.setRentType("??????");
        item.setSales(300L);
        info = new HashMap<>();
        info.put("years", "2000");
        info.put("type", "2???1???");
        info.put("level", "6/6???");
        info.put("style", "????????????");
        info.put("orientation", "??????");
        item.setInfo(info);
        item.setTitle("???????????????");
        items.add(item);

        Collection<Item> result = mongoTemplate.insert(items, Item.class);
        System.out.println(result);
    }

}