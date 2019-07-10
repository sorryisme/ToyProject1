package com.sorry.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.sorry.service.BoardService;
import com.sorry.service.DartAPIService;
import com.sorry.web.vo.BoardVO;
import com.sorry.web.vo.ResultVO;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    DartAPIService dartAPIservice;

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
    public ResponseEntity<Object> boardInsert() {
        Map<String, Object> result = new HashMap<>();
        dartAPIservice.insert();
        ResponseEntity <Object> responseEntity;
        responseEntity = new ResponseEntity<>(result,HttpStatus.OK);
        result.put("result", "succexss");
        return responseEntity;
    }

}
