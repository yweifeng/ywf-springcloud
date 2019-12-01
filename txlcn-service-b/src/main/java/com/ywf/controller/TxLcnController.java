package com.ywf.controller;

import com.ywf.service.ITxLcnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:ywf
 */
@RestController
public class TxLcnController {

    @Autowired
    private ITxLcnService txLcnService;

    /**
     * 测试txlcn 分布式事务
     * @param flag
     *  flag:0 不发生异常
     *  flag:1 txlcn-service-a发生异常
     *  flag:2 txlcn-service-b发生异常
     *  flag:3 txlcn-service-c发生异常
     * @return
     */
    @RequestMapping("/testRpcB")
    public String testRpc(@RequestParam String flag) {
        return txLcnService.rpc(flag);
    }
}
