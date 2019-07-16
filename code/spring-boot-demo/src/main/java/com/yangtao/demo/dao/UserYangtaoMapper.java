package com.yangtao.demo.dao;

import com.yangtao.demo.model.UserYangtao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserYangtaoMapper {
    int insert(UserYangtao record);

    List<UserYangtao> selectAll();
}