package com.ztt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/2/28 17:16
 */
@RestController
@RequestMapping("feign-server")
public class FeignController {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHiFromFeignServer(@RequestParam(value = "name") String name) {
        return "hello" + name;
    }
}
