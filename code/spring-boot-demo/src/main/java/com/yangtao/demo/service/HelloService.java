package com.yangtao.demo.service;

import com.yangtao.demo.dao.UserYangtaoMapper;
import com.yangtao.demo.model.UserYangtao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : yangtao
 * @date : 2019/7/13 16:12
 * @Description :
 */

public class HelloService {
    private UserYangtaoMapper mapper;
    public UserYangtao getUser() {
        return mapper.selectAll().get(0);
    }

}
