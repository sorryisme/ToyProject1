package com.sorry.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.sorry.service.DartAPIService;
import com.sorry.web.vo.ResultVO;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired 
    DartAPIService dartAPIservice;
    
    
    @RequestMapping("/main")
    public Object main() {
//        String url = "http://dart.fss.or.kr/api/search.json?auth=7a55cad488b3db550096ff6d6adaa0acab1ce84f&end_dt=20190607&dsp_tp=A&bsn_tp=A003";
//          RestTemplate restTemplate = new RestTemplate();
//          String result = restTemplate.getForObject(url, String.class);
//          Gson gson = new Gson();
//          ResultVO vo = gson.fromJson(result, ResultVO.class);
//          System.out.println(vo.toString());
        dartAPIservice.insert();
        return null;
    }
    
    
}
