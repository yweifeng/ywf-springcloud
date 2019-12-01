package com.ywf.controller;

import com.ywf.client.NacosProvicerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FeignController {
    @Autowired
    NacosProvicerClient nacosProvicerClient;

    @GetMapping("/hi-feign")
    public String hiFeign(){
        return nacosProvicerClient.hi("ywf");
    }
}
