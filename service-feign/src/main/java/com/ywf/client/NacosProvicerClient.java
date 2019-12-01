package com.ywf.client;

import com.ywf.hystrix.NacosProviderClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ywf
 */
@FeignClient(value = "nacos-provider", fallback = NacosProviderClientHystrix.class)
public interface NacosProvicerClient {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String hi(@RequestParam(value = "name", defaultValue = "ywf", required = false) String name);
}
