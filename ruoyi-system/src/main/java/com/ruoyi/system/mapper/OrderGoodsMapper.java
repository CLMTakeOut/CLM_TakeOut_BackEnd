package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.OrderGoods;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * date: 2021/5/22 17:34
 * 说明:
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
@Repository
public interface OrderGoodsMapper {
    /*根据订单id查询对应的商品*/
    ArrayList<OrderGoods> selectOrderGoodsById(Integer orderId);
}
