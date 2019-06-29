package com.sorry.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sorry.service.CrawlerService;

@RestController
@RequestMapping("/")
public class CrawlerController {
    
    @Autowired
    CrawlerService crawlerService;
    
    @RequestMapping("/crawTest")
    public Object insertCrawler(String rcpNo) {
        rcpNo = "1";
        crawlerService.insertCrawValue(rcpNo);
        
        Map<String,Object> map = new HashMap<>();
        map.put("staus","Success");
        
        return map;
        
    }
    
}
