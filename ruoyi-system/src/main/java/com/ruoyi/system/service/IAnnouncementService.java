package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Announcement;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public interface IAnnouncementService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param announcementId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Announcement selectAnnouncementById(Integer announcementId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param announcement 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Announcement> selectAnnouncementList(Announcement announcement);

    /**
     * 新增【请填写功能名称】
     * 
     * @param announcement 【请填写功能名称】
     * @return 结果
     */
    public int insertAnnouncement(Announcement announcement);

    /**
     * 修改【请填写功能名称】
     * 
     * @param announcement 【请填写功能名称】
     * @return 结果
     */
    public int updateAnnouncement(Announcement announcement);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param announcementIds 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAnnouncementByIds(Integer[] announcementIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param announcementId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAnnouncementById(Integer announcementId);
}
