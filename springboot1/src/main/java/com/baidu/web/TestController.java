package com.baidu.web;

import com.baidu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private TestService testService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("test.do")
    public List<Map<String,Object>> test(){
        List<Map<String,Object>> list = testService.getList();

          redisTemplate.opsForValue().set("56","56161351651");
          redisTemplate.convertAndSend("channel","this is message");
         return list;
    }

}
