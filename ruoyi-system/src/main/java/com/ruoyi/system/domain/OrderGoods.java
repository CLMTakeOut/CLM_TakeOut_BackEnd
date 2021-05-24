package com.ruoyi.system.domain;

import java.util.ArrayList;

/**
 * date: 2021/5/22 17:22
 * 说明: 订单和商品的映射类
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
public class OrderGoods {
    /*订单商品id*/
   private Integer orderGoodsId;

   /*订单id*/
    private Integer orderId;

    /*商品id*/
    private Integer goodsId;

    /*商品对象*/
    private Goods goods;

    /*商品数量*/
    private Integer goodsAmount;

    public OrderGoods() {
    }

    public OrderGoods(Integer orderGoodsId, Integer orderId, Integer goodsId, Goods goods, Integer goodsAmount) {
        this.orderGoodsId = orderGoodsId;
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.goods = goods;
        this.goodsAmount = goodsAmount;
    }

    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "orderGoodsId=" + orderGoodsId +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", goods=" + goods +
                ", goodsAmount=" + goodsAmount +
                '}';
    }
}
