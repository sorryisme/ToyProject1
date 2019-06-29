package com.sorry.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sorry.web.vo.CrawlerVO;

@Mapper
public interface CrawlerDAO {

    public int insert(CrawlerVO crawlerVO);
    
}
