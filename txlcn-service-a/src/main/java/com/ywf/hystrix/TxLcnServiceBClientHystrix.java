package com.ywf.hystrix;

import com.ywf.client.TxLcnServiceBClient;
import com.ywf.client.TxLcnServiceCClient;
import org.springframework.stereotype.Component;

/**
 * @Author:ywf
 */
@Component
public class TxLcnServiceBClientHystrix implements TxLcnServiceBClient {
    @Override
    public String testRpc(String flag) {
        throw new RuntimeException("testRpc b error");
    }
}
