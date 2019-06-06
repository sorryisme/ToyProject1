package com.sorry.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sorry.service.BoardService;
import com.sorry.web.vo.BoardVO;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;
    
    @RequestMapping("/list")
    public ResponseEntity<Object> BoardList() {
        
        Map<String, Object> result = new HashMap<>();
        List<BoardVO> board = boardService.selectList();
        
        ResponseEntity <Object> responseEntity;
        responseEntity = new ResponseEntity<>(result,HttpStatus.OK);
        result.put("board", board);

        return responseEntity;
    }
    
}
