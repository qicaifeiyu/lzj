package controller;

import com.wjc.commons.result.lzjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.RecommendationService;

/**
 * 热门推荐服务控制层
 */
@RestController
@RequestMapping("/recommendation")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("")
    public lzjResult selectRecommendationList(String city) {
        return recommendationService.selectRecommendationList(city);
    }

}