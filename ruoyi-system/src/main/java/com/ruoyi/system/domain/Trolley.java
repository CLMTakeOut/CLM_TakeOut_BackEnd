package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 trolley
 * 
 * @author ruoyi
 * @date 2021-06-05
 */
public class Trolley extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long trolleyId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long goodsId;
    // 商品对象
    private Goods goods;
    // 商品数量
    private Integer goodsAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long customerId;
    // 是否勾选
    private Boolean isCheck = false;

    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public void setTrolleyId(Long trolleyId)
    {
        this.trolleyId = trolleyId;
    }

    public Long getTrolleyId() 
    {
        return trolleyId;
    }
    public void setGoodsId(Long goodsId) 
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId() 
    {
        return goodsId;
    }
    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public Long getCustomerId() 
    {
        return customerId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("trolleyId", getTrolleyId())
            .append("goodsId", getGoodsId())
            .append("customerId", getCustomerId())
            .toString();
    }
}
