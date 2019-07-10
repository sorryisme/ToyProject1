package com.sorry.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorry.dao.CrawlerDAO;
import com.sorry.web.vo.CrawlerVO;

@Service
public class CrawlerInsertService {
    
    public static CrawlerInsertService instance;
    
    public static CrawlerInsertService getInstance() {
        return instance;
    }
    
    public CrawlerInsertService() {
        if (instance == null)
            instance = this;
    }

    @Autowired
    CrawlerDAO crawlerDAO;
    
    public int insertCrwalingData(CrawlerVO crawlerVO) {
        int result = crawlerDAO.insert(crawlerVO);
        return result;
    }
    
    
}
