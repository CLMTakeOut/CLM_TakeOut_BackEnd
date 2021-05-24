package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.OrderGoods;
import com.ruoyi.system.mapper.OrderGoodsMapper;
import com.ruoyi.system.service.OrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * date: 2021/5/22 18:28
 * 说明:
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
@Service
public class OrderGoodsServiceImpl implements OrderGoodsService {
    OrderGoodsMapper orderGoodsMapper;
    @Autowired
    public void setOrderGoodsMapper(OrderGoodsMapper orderGoodsMapper) {
        this.orderGoodsMapper = orderGoodsMapper;
    }

    @Override
    public ArrayList<OrderGoods> selectOrderGoodsById(Integer orderId) {
        return orderGoodsMapper.selectOrderGoodsById(orderId);
    }
}
