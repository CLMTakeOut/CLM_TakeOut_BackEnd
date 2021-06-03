package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 address
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public class Address extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 地址id(主键) */
    private Integer addressId;

    /** 用户id(外键) */
    @Excel(name = "用户id(外键)")
    private Integer customerId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 电话 */
    @Excel(name = "电话")
    private String telephone;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;
    private Integer using;


    public Address(Integer addressId, Integer customerId, String name, String telephone, String address, Integer using) {
        this.addressId = addressId;
        this.customerId = customerId;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.using = using;
    }

    public Integer getUsing() {
        return using;
    }

    public void setUsing(Integer using) {
        this.using = using;
    }

    public void setAddressId(Integer addressId)
    {
        this.addressId = addressId;
    }

    public Integer getAddressId() 
    {
        return addressId;
    }
    public void setCustomerId(Integer customerId) 
    {
        this.customerId = customerId;
    }

    public Integer getCustomerId() 
    {
        return customerId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("addressId", getAddressId())
            .append("customerId", getCustomerId())
            .append("name", getName())
            .append("telephone", getTelephone())
            .append("address", getAddress())
            .toString();
    }
}
