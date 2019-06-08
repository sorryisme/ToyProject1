package com.sorry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import edu.uci.ics.crawler4j.url.WebURL;

public class Crawler  extends WebCrawler{

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        return url.getURL().startsWith("http://dart.fss.or.kr/");
    }

    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        try {
            HtmlParseData data = (HtmlParseData) page.getParseData();
            
            Document doc = Jsoup.parse(data.getHtml());
            String content = doc.select(".table_tit > b").text();
            int startIndex = content.indexOf("체") + 1;
            int endIndex = content.indexOf("건") - 1;
            System.out.println(url +":"+content);
            System.out.println(content.substring(startIndex, endIndex));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}
