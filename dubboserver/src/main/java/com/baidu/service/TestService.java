package com.baidu.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baidu.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service(version = "1.0.0")
public class TestService implements TestServiceInterface {

    @Autowired
    private TestMapper testMapper;

    @Override
    public int insert(Map<String, Object> map) {
        return testMapper.insert(map);
    }
    @Transactional
    @Override
    public List<Map<String, Object>> queryList(Map<String, Object> map) {
        return testMapper.query(map);
    }
}
