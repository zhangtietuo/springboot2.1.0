package com.ztt.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/2/28 16:58
 */
@FeignClient("message")
public interface FeignService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromFeignServer(@RequestParam(value = "name") String name);

}
