package com.sorry.service.Impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sorry.web.vo.GlobalVO;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class CrawlingService extends WebCrawler{
    
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        return url.getURL().startsWith("http://dart.fss.or.kr/dsaf001/main.do");
    }
    

    @Override
    public void visit(Page page) {
//        String url = page.getWebURL().getURL();
        try {
            HtmlParseData data = (HtmlParseData) page.getParseData();
            
            Document doc = Jsoup.parse(data.getHtml());
            
//            String content = doc.select("a[href=\"#download\"]").attr("onclick");
            
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
            
            System.out.println(matchingValue[1]);
            //rcpNo: "", dcmNo: "", eleId: "", offset: "", length: "", dtd: ""}
            //rcpNo = [1], dcmNo = [3], eleid =15, offset = [7], length = [9], dtd = dart3.xsd 
            GlobalVO.crawlerVO.setRcpNo(matchingValue[1]);
            GlobalVO.crawlerVO.setDcmNo(matchingValue[3]);
            GlobalVO.crawlerVO.setOffset_no(matchingValue[7]);
            GlobalVO.crawlerVO.setLength_no(matchingValue[9]);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
