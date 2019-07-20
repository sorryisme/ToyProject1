package com.sorry.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sorry.web.vo.ExcelVO;

@Mapper
public interface ExcelDAO {
    
    public int updateProfit(ExcelVO excelVO);
    
}
