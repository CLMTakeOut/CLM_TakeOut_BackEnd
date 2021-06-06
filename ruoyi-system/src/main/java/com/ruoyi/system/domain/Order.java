package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.ArrayList;

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

    /*客户实体*/
    private Customer customer;

    /*订单编号*/
    @Excel(name = "订单编号")
    private String orderNumber;

    /*配送地址*/
    private String dispatchAddress;

    /** 下单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String orderTime;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Integer orderStatus;
    private ArrayList<OrderGoods> orderGoodsList;
    /*订单总价格*/
    private Double totalPrice;


    public ArrayList<OrderGoods> getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(ArrayList<OrderGoods> orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDispatchAddress() {
        return dispatchAddress;
    }

    public void setDispatchAddress(String dispatchAddress) {
        this.dispatchAddress = dispatchAddress;
    }

    public void setCustomerId(Integer customerId)
    {
        this.customerId = customerId;
    }

    public Integer getCustomerId() 
    {
        return customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderTime(String orderTime)
    {
        this.orderTime = orderTime;
    }

    public String getOrderTime()
    {
        return orderTime;
    }
    public void setOrderStatus(Integer orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderStatus()
    {
        return orderStatus;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
                .append("orderNumber", getOrderNumber())
            .append("customerId", getCustomerId())
            .append("orderTime", getOrderTime())
            .append("orderStatus", getOrderStatus())
            .toString();
    }
}
