package com.baidu.service;

import com.baidu.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TestService {

     @Autowired
     private TestMapper testMapper;

     public List<Map<String,Object>> getList(){
         return testMapper.getList();
     }

}
