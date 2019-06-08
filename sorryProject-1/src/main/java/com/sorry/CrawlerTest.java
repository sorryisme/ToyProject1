package com.sorry;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class CrawlerTest {
    public static void main(String[] args) {
        int numberOfCrawlers = 1;
        CrawlConfig config = new CrawlConfig();
        config.setMaxDepthOfCrawling(1);
        config.setCrawlStorageFolder("/data/craw/root");
        
        try {
            
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig,pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        
        controller.addSeed("http://dart.fss.or.kr/dsac001/mainAll.do");
        controller.start(Crawler.class, numberOfCrawlers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
