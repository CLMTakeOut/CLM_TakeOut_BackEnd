package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 goods
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public class Goods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id(主键) */
    private Integer goodsId;

    /** 店铺id(外键） */
    @Excel(name = "店铺id(外键）")
    private Integer shopId;

    /*店铺名*/
    private String shopName;

    /** 商品名 */
    @Excel(name = "商品名")
    private String goodsName;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private Double price;

    /** 销售量 */
    @Excel(name = "销售量")
    private Integer salesVolume;

    /** 评分 */
    @Excel(name = "评分")
    private Long score;

    /** 详细描述 */
    @Excel(name = "详细描述")
    private String goodsDescribe;

    /** 商品图片 */
    @Excel(name = "商品图片")
    private String goodsLogo;

    /** 推荐商品？ */
    @Excel(name = "推荐商品？")
    private Integer goodsRecommend;

    // 商品类型
    private String goodsType;

    // 数量
    public Integer amount = 0;

    public Integer getSalesVolume() {
        return salesVolume;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public void setGoodsId(Integer goodsId)
    {
        this.goodsId = goodsId;
    }

    public Integer getGoodsId() 
    {
        return goodsId;
    }
    public void setShopId(Integer shopId) 
    {
        this.shopId = shopId;
    }

    public Integer getShopId() 
    {
        return shopId;
    }
    public void setGoodsName(String goodsName) 
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName() 
    {
        return goodsName;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getPrice()
    {
        return price;
    }
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setScore(Long score) 
    {
        this.score = score;
    }

    public Long getScore() 
    {
        return score;
    }
    public void setGoodsDescribe(String describe)
    {
        this.goodsDescribe = describe;
    }

    public String getGoodsDescribe()
    {
        return goodsDescribe;
    }
    public void setGoodsLogo(String goodsLogo) 
    {
        this.goodsLogo = goodsLogo;
    }

    public String getGoodsLogo() 
    {
        return goodsLogo;
    }
    public void setGoodsRecommend(Integer goodsRecommend)
    {
        this.goodsRecommend = goodsRecommend;
    }

    public Integer getGoodsRecommend()
    {
        return goodsRecommend;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodsId", getGoodsId())
            .append("shopId", getShopId())
            .append("goodsName", getGoodsName())
            .append("price", getPrice())
            .append("salesvolume", getSalesVolume())
            .append("score", getScore())
            .append("describe", getGoodsDescribe())
            .append("goodsLogo", getGoodsLogo())
            .append("goodsRecommend", getGoodsRecommend())
            .toString();
    }
}
