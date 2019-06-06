package com.sorry.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.sorry.dao.BoardDAO;
import com.sorry.service.BoardService;
import com.sorry.web.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardDAO boardDAO;
    
    @Override
    public List<BoardVO> selectList() {
        return boardDAO.selectList();
    }
    
}
