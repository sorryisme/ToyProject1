package com.sorry.service.Impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sorry.web.vo.CrawlerVO;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class CrawlingService extends WebCrawler{
    CrawlerVO crawlerVO= new CrawlerVO();

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        return url.getURL().startsWith("http://dart.fss.or.kr/");
    }
    
    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        try {
           if(url.startsWith("http://dart.fss.or.kr/dsaf001")) {
               crwalingViewDoc(page);
           } else {
               crwalingDoc(page);
           }
               
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int crwalingViewDoc(Page page) {
        HtmlParseData data = (HtmlParseData) page.getParseData();
        Document doc = Jsoup.parse(data.getHtml());
        Pattern pattern = Pattern.compile("viewDoc\\('\\d*', '\\d*\\', '15', '\\d*\\', '\\d*', 'dart3.xsd'"); 
        //8번째 스크립트를 추출한다
        Elements scriptElements = doc.select("script").eq(8);
        String[] matchingValue = null;
        
        //정규표현식을 통해 정보값을 획득한다
        for(Element element : scriptElements) {
            Matcher matcher = pattern.matcher(element.data());
            if(matcher.find()){
                matchingValue = matcher.group().split("\'");
            }
        }
        
        //rcpNo: "", dcmNo: "", eleId: "", offset: "", length: "", dtd: ""}
        //rcpNo = [1], dcmNo = [3], eleid =15, offset = [7], length = [9], dtd = dart3.xsd
        crawlerVO.setRcpNo(matchingValue[1]);
        crawlerVO.setDcmNo(matchingValue[3]);
        crawlerVO.setOffset_no(matchingValue[7]);
        crawlerVO.setLength_no(matchingValue[9]);
        
        return CrawlerInsertService.getInstance().insertCrwalingData(crawlerVO);
    }
    public int crwalingDoc(Page page) {
        HtmlParseData data = (HtmlParseData) page.getParseData();
        Document doc = Jsoup.parse(data.getHtml());
            Elements elements = doc.select(".nb").eq(1).next().select("tr").eq(6).select("p");
            System.out.println(elements.eq(1).toString().replaceAll("<p>", "").replaceAll("</p>", ""));
            System.out.println(elements.eq(3).toString().replaceAll("<p>", "").replaceAll("</p>", ""));
        return 0;
    }
    
    
}
