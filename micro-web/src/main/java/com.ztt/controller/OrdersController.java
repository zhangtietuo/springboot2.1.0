package com.ztt.controller;

import com.ztt.service.OrdersService;
import com.ztt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/5/23 9:35
 */
@RestController
public class OrdersController {

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    private final OrdersService ordersService;

    private final Logger log = LoggerFactory.getLogger(getClass());
}
