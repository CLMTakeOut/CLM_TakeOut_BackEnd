package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 customer
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public class Customer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id(主键) */
    private Integer customerId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String customerName;

    /** 密码 */
    @Excel(name = "密码")
    private String customerPwd;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 电话 */
    @Excel(name = "电话")
    private String telephone;

    /** 余额 */
    @Excel(name = "余额")
    private Long balance;

    /** 积分 */
    @Excel(name = "积分")
    private Long integral;

    /** 用户头像 */
    @Excel(name = "用户头像")
    private String customerPortrait;

    public void setCustomerId(Integer customerId) 
    {
        this.customerId = customerId;
    }

    public Integer getCustomerId() 
    {
        return customerId;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setCustomerPwd(String customerPwd) 
    {
        this.customerPwd = customerPwd;
    }

    public String getCustomerPwd() 
    {
        return customerPwd;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setBalance(Long balance) 
    {
        this.balance = balance;
    }

    public Long getBalance() 
    {
        return balance;
    }
    public void setIntegral(Long integral) 
    {
        this.integral = integral;
    }

    public Long getIntegral() 
    {
        return integral;
    }
    public void setCustomerPortrait(String customerPortrait) 
    {
        this.customerPortrait = customerPortrait;
    }

    public String getCustomerPortrait() 
    {
        return customerPortrait;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("customerId", getCustomerId())
            .append("customerName", getCustomerName())
            .append("customerPwd", getCustomerPwd())
            .append("sex", getSex())
            .append("telephone", getTelephone())
            .append("balance", getBalance())
            .append("integral", getIntegral())
            .append("customerPortrait", getCustomerPortrait())
            .toString();
    }
}
