package com.sorry.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.sorry.dao.BoardDAO;
import com.sorry.service.DartAPIService;
import com.sorry.web.vo.ResultVO;

@Service
public class DartAPIServiceImpl implements DartAPIService{
  
    @Autowired
    BoardDAO boardDAO;
    
    private static final String URL= "http://dart.fss.or.kr/api/search.json?auth=7a55cad488b3db550096ff6d6adaa0acab1ce84f&end_dt=20190607&dsp_tp=A&bsn_tp=A003";
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public int insert() {
        String str = restTemplate.getForObject(URL, String.class);
        ResultVO result = parse2VO(str);
        System.out.println(result.toString());
        return 0;
    }

    public ResultVO parse2VO(String str) {
        return new Gson().fromJson(str, ResultVO.class); 
    }
}
