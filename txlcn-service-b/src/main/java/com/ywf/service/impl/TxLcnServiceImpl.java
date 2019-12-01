package com.ywf.service.impl;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.ywf.entity.User;
import com.ywf.mapper.UserMapper;
import com.ywf.service.ITxLcnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

/**
 * @Author:ywf
 */

@Service
public class TxLcnServiceImpl implements ITxLcnService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    @LcnTransaction
    public String rpc(String flag) {

        User u = new User();
        u.setUser_name("txlcn-service-b:" + new Date());
        u.setUser_password("1");
        userMapper.insertUser(u);
        // txlcn-service-a 发生异常
        if (Objects.equals(flag, "2")) {
            int i = 1/0;
        }
        return "txlcn-service-b success";
    }
}
