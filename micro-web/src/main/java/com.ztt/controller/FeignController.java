package com.ztt.controller;

import com.ztt.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/2/28 16:58
 */
@RestController
@RequestMapping("/web")
//@Controller @ResponseBody
public class FeignController {

    @Autowired
    FeignService feignService;

    @GetMapping("/feignMethod")
    public void feignMethod() {
        feignService.sayHiFromFeignServer("ztt-feign");
    }


}
