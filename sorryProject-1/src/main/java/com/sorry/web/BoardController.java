package com.sorry.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sorry.service.BoardService;
import com.sorry.service.DartAPIService;
import com.sorry.service.ExcelService;
import com.sorry.web.vo.BoardVO;

@RestController
@RequestMapping("/board")
public class BoardController {
    Logger logger = LoggerFactory.getLogger(BoardController.class);
    
    @Autowired
    BoardService boardService;

    @Autowired
    DartAPIService dartAPIservice;
    
    @Autowired
    ExcelService excelService;

    @RequestMapping("/list")
    public ResponseEntity<Object> boardList() {

        Map<String, Object> result = new HashMap<>();
        List<BoardVO> board = boardService.selectList();

        ResponseEntity <Object> responseEntity;
        responseEntity = new ResponseEntity<>(result,HttpStatus.OK);
        result.put("board", board);
        result.put("result", "success");
        return responseEntity;
    }

    @RequestMapping("/insert")
    public Object boardInsert() {
        Map<String, Object> result = new HashMap<>();
        int resultCount = dartAPIservice.insert();
        
        if( resultCount > 0 ) {
            result.put("result", "success");
            result.put("resultCount", resultCount);
        } else {
            result.put("result", "fail");
        }
        
        logger.info(resultCount + "");
        return result;
    }
    
    @RequestMapping("/excelInsert")
    public ResponseEntity<Object> excelInsert(@RequestParam("fileName[]") String[] fileName) {
        Map<String, Object> result = new HashMap<>();
        for(String fileStr :fileName) {
            excelService.insertExcel(fileStr);
        }
        ResponseEntity <Object> responseEntity;
        responseEntity = new ResponseEntity<>(result,HttpStatus.OK);
        result.put("result", "success");
        return responseEntity;
    }
}
