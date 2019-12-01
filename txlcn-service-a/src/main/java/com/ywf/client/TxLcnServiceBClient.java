package com.ywf.client;

import com.ywf.hystrix.TxLcnServiceBClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:ywf
 */
@FeignClient(value = "txlcn-service-b", fallback = TxLcnServiceBClientHystrix.class)
public interface TxLcnServiceBClient {

    @RequestMapping(value = "/testRpcB")
    String testRpc(@RequestParam String flag);
}
