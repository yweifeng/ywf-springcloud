package com.ywf.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.mysql.cj.log.LogFactory;
import com.ywf.client.TxLcnServiceBClient;
import com.ywf.client.TxLcnServiceCClient;
import com.ywf.entity.User;
import com.ywf.mapper.UserMapper;
import com.ywf.service.ITxLcnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @Author:ywf
 */

@Service
public class TxLcnServiceImpl implements ITxLcnService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TxLcnServiceBClient serviceBClient;

    @Autowired
    private TxLcnServiceCClient serviceCClient;

    @Override
    @LcnTransaction
    @Transactional
    public String rpc(String flag) {

        // 调用txlcn-service-b
        String bResult = serviceBClient.testRpc(flag);

        // 调用txlcn-service-c
        String cResult = serviceCClient.testRpc(flag);

        User u = new User();
        u.setUser_name("txlcn-service-a:" + new Date());
        u.setUser_password("1");
        userMapper.insertUser(u);
        // txlcn-service-a 发生异常
        if (Objects.equals(flag, "1")) {
            int i = 1/0;
        }
        return bResult + ">>" + cResult + ">>" + " all success";
    }
}
