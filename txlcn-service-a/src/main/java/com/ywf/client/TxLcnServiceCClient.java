package com.ywf.client;

import com.ywf.hystrix.TxLcnServiceCClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:ywf
 */
@FeignClient(value = "txlcn-service-c", fallback = TxLcnServiceCClientHystrix.class)
public interface TxLcnServiceCClient {

    @RequestMapping(value = "/testRpcC")
    String testRpc(@RequestParam String flag);
}
