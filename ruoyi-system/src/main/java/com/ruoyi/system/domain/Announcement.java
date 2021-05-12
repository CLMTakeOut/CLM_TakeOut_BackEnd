package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 announcement
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public class Announcement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公告id */
    private Integer announcementId;

    /** 店铺id */
    @Excel(name = "店铺id")
    private Integer shopId;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer customerId;

    /** 图片 */
    @Excel(name = "图片")
    private String picture;

    /** 详情 */
    @Excel(name = "详情")
    private String notice;

    public void setAnnouncementId(Integer announcementId) 
    {
        this.announcementId = announcementId;
    }

    public Integer getAnnouncementId() 
    {
        return announcementId;
    }
    public void setShopId(Integer shopId) 
    {
        this.shopId = shopId;
    }

    public Integer getShopId() 
    {
        return shopId;
    }
    public void setCustomerId(Integer customerId) 
    {
        this.customerId = customerId;
    }

    public Integer getCustomerId() 
    {
        return customerId;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }
    public void setNotice(String notice) 
    {
        this.notice = notice;
    }

    public String getNotice() 
    {
        return notice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("announcementId", getAnnouncementId())
            .append("shopId", getShopId())
            .append("customerId", getCustomerId())
            .append("picture", getPicture())
            .append("notice", getNotice())
            .toString();
    }
}
