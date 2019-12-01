package com.ywf.hystrix;

import com.ywf.client.TxLcnServiceCClient;
import org.springframework.stereotype.Component;

/**
 * @Author:ywf
 */
@Component
public class TxLcnServiceCClientHystrix implements TxLcnServiceCClient {
    @Override
    public String testRpc(String flag) {
        throw new RuntimeException("testRpc c error");
    }
}
