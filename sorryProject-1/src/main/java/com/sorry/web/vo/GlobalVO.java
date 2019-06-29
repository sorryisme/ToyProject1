package com.sorry.web.vo;

public class GlobalVO {
    //어떻게 처리할지 몰라서 임시로 static 처리
    public static CrawlerVO crawlerVO;
    static {
        crawlerVO = new CrawlerVO();
    }
    
    
}
