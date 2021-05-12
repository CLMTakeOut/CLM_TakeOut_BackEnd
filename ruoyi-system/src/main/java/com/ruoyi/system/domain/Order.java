package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 order
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public class Order extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id(主键) */
    private Long orderId;

    /** 用户id(外键) */
    @Excel(name = "用户id(外键)")
    private Integer customerId;

    /** 店铺id(外键) */
    @Excel(name = "店铺id(外键)")
    private Integer shopId;

    /** 商品id(外键) */
    @Excel(name = "商品id(外键)")
    private Integer goodsId;

    /** 下单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String orderStatus;

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setCustomerId(Integer customerId) 
    {
        this.customerId = customerId;
    }

    public Integer getCustomerId() 
    {
        return customerId;
    }
    public void setShopId(Integer shopId) 
    {
        this.shopId = shopId;
    }

    public Integer getShopId() 
    {
        return shopId;
    }
    public void setGoodsId(Integer goodsId) 
    {
        this.goodsId = goodsId;
    }

    public Integer getGoodsId() 
    {
        return goodsId;
    }
    public void setOrderTime(Date orderTime) 
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() 
    {
        return orderTime;
    }
    public void setOrderStatus(String orderStatus) 
    {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() 
    {
        return orderStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("customerId", getCustomerId())
            .append("shopId", getShopId())
            .append("goodsId", getGoodsId())
            .append("orderTime", getOrderTime())
            .append("orderStatus", getOrderStatus())
            .toString();
    }
}
