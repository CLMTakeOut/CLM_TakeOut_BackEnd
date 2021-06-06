package com.ruoyi.system.service;

import com.ruoyi.system.domain.OrderGoods;

import java.util.ArrayList;

/**
 * date: 2021/5/22 18:27
 * 说明:
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
public interface OrderGoodsService {
    ArrayList<OrderGoods> selectOrderGoodsById(Integer orderId);
    int insertGoodsList(ArrayList<OrderGoods> orderGoodsList);
}
