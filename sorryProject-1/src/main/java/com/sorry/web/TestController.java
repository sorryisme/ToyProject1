package com.sorry.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping("/main")
    public Object main() {
        
        Map<String, Object> result = new HashMap<>();
        result.put("status", "success");
        
        
        return result;
    }
    
    
}
