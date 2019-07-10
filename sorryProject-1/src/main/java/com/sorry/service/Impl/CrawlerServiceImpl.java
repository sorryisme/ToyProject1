package com.sorry.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorry.dao.CrawlerDAO;
import com.sorry.service.CrawlerService;
import com.sorry.web.vo.GlobalVO;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

@Service
public class CrawlerServiceImpl implements CrawlerService{
    
//    @Autowired 
//    CrawlerDAO crawlerDAO;
    @Override
    public int insertCrawValue(String rcpNo) {
        int numberOfCrawlers = 1;
        CrawlConfig config = new CrawlConfig();
        config.setMaxDepthOfCrawling(0);
        config.setCrawlStorageFolder("/data/craw/root");
        config.setIncludeBinaryContentInCrawling(false);
        config.setPolitenessDelay(10);
        config.setIncludeHttpsPages(false);
        
        try {
            PageFetcher pageFetcher = new PageFetcher(config);
            RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
            robotstxtConfig.setEnabled(false);
            RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig,pageFetcher);
            
            CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
//            controller.addSeed("http://dart.fss.or.kr/dsaf001/main.do?rcpNo=20190628000367");
            controller.addSeed("http://dart.fss.or.kr/report/viewer.do?rcpNo=20190628000367&dcmNo=6790573&eleId=15&offset=172334&length=47071&dtd=dart3.xsd");
            controller.startNonBlocking(CrawlingService.class, numberOfCrawlers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return 1;
    }
    
   
}
