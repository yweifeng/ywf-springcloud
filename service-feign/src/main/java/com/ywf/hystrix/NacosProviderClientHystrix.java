package com.ywf.hystrix;

import com.ywf.client.NacosProvicerClient;
import org.springframework.stereotype.Component;

/**
 * @Author:ywf
 */
@Component
public class NacosProviderClientHystrix implements NacosProvicerClient {
    @Override
    public String hi(String name) {
        return "error " +name;
    }
}
