package com.baidu.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestMapper {

     public int insert (Map<String,Object> map);

     public List<Map<String,Object>> query(Map<String,Object> map);
}
