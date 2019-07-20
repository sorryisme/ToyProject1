package com.sorry.service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.sorry.dao.BoardDAO;
import com.sorry.service.DartAPIService;
import com.sorry.web.vo.ApiVO;
import com.sorry.web.vo.ResultVO;

@Service
public class DartAPIServiceImpl implements DartAPIService{
    Logger logger = LoggerFactory.getLogger(DartAPIServiceImpl.class);
    
    @Autowired
    BoardDAO boardDAO;
    
    private static final String URL= "http://dart.fss.or.kr/api/search.json?auth=7a55cad488b3db550096ff6d6adaa0acab1ce84f&end_dt=";
    private static final String URL2 = "&dsp_tp=A&bsn_tp=A003";

    @Override
    public int insert() {
        
        RestTemplate restTemplate = new RestTemplate();
        String restUrl = URL + 
//                getToday() 
                "20190717"
                + URL2;
        String str = restTemplate.getForObject(restUrl , String.class);
      
        ResultVO result = parse2VO(str);
        Iterator<ApiVO> it =toIterator(result.getList());
        
        int count = 0; 
        
        while(it.hasNext()) {
            ApiVO vo = it.next();
            String remarks = vo.getRcp_dt() + vo.getCrp_nm();
           
            if( isExist(remarks)  > 0) {
                logger.info("이미 존재합니다");
                continue;
            } else {
                vo.setRmk(remarks);
                boardDAO.insert(vo);
                count ++;
            }
        }
        
        return count;
    }
    
    /**
     * @param String str : remarks
     * @return int : Exist Count  
     * */
    public int isExist(String str) {
        return boardDAO.isExist(str);
    }
    
    /**
     * @param remarks : 식별
     * @return count : 존재여부 
     * */
    public Iterator<ApiVO> toIterator(List<ApiVO> list) {
        return list.iterator();
    }
    
    /**
     * @param String str: json String
     * @return ResultVO
     * */
    public ResultVO parse2VO(String str) {
        return new Gson().fromJson(str, ResultVO.class); 
    }
    
    /**
     * @return String today : return yyyyMMdd format Date
     * */
    public String getToday() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date()); 
    }
    
}
