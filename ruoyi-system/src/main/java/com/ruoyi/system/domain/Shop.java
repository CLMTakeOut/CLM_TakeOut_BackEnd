package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 shop
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public class Shop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 店铺id(主键) */
    private Integer shopId;

    /** 店铺名 */
    @Excel(name = "店铺名")
    private String shopName;

    /** 店铺地址 */
    @Excel(name = "店铺地址")
    private String shopAddress;

    /** 联系人 */
    @Excel(name = "联系人")
    private String shopContacts;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String shopTelephone;

    /** 店铺logo */
    @Excel(name = "店铺logo")
    private String shopLogo;

    public void setShopId(Integer shopId) 
    {
        this.shopId = shopId;
    }

    public Integer getShopId() 
    {
        return shopId;
    }
    public void setShopName(String shopName) 
    {
        this.shopName = shopName;
    }

    public String getShopName() 
    {
        return shopName;
    }
    public void setShopAddress(String shopAddress) 
    {
        this.shopAddress = shopAddress;
    }

    public String getShopAddress() 
    {
        return shopAddress;
    }
    public void setShopContacts(String shopContacts) 
    {
        this.shopContacts = shopContacts;
    }

    public String getShopContacts() 
    {
        return shopContacts;
    }
    public void setShopTelephone(String shopTelephone) 
    {
        this.shopTelephone = shopTelephone;
    }

    public String getShopTelephone() 
    {
        return shopTelephone;
    }
    public void setShopLogo(String shopLogo) 
    {
        this.shopLogo = shopLogo;
    }

    public String getShopLogo() 
    {
        return shopLogo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("shopId", getShopId())
            .append("shopName", getShopName())
            .append("shopAddress", getShopAddress())
            .append("shopContacts", getShopContacts())
            .append("shopTelephone", getShopTelephone())
            .append("shopLogo", getShopLogo())
            .toString();
    }
}
