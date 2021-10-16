package com.ztt.service.impl;

import com.ztt.domain.Orders;
import com.ztt.mapper.OrdersMapper;
import com.ztt.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2018/5/23 9:38
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public List<Orders> findAll() {
        return ordersMapper.findAll();
    }
}
