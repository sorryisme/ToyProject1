package com.sorry.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sorry.service.DartAPIService;

@RestController
@RequestMapping("api")
public class APIController {
    
    @Autowired
    DartAPIService dartAPIService;
    
    @RequestMapping("/dart")
    public Object main() {
       Map <String, Object> result = new HashMap<>();
       result.put("status", "success");
       
       return result;
    }
    
}
