package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 collection
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public class Favorite extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 收藏id */
    private Integer collectionId;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer customerId;

    /** 商品id */
    @Excel(name = "商品id")
    private Integer goodsId;

    public void setCollectionId(Integer collectionId) 
    {
        this.collectionId = collectionId;
    }

    public Integer getCollectionId() 
    {
        return collectionId;
    }
    public void setCustomerId(Integer customerId) 
    {
        this.customerId = customerId;
    }

    public Integer getCustomerId() 
    {
        return customerId;
    }
    public void setGoodsId(Integer goodsId) 
    {
        this.goodsId = goodsId;
    }

    public Integer getGoodsId() 
    {
        return goodsId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("collectionId", getCollectionId())
            .append("customerId", getCustomerId())
            .append("goodsId", getGoodsId())
            .toString();
    }
}
