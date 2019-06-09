package com.sorry.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sorry.web.vo.BoardVO;
import com.sorry.web.vo.ResultVO;

@Mapper
public interface BoardDAO {

    public List<BoardVO> selectList();
    public int isExist(String remarks);
    public int insert(ResultVO resultVO);
}
