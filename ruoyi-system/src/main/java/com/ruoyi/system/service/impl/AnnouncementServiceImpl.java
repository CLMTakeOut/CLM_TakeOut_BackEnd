package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AnnouncementMapper;
import com.ruoyi.system.domain.Announcement;
import com.ruoyi.system.service.IAnnouncementService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
@Service
public class AnnouncementServiceImpl implements IAnnouncementService 
{
    @Autowired
    private AnnouncementMapper announcementMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param announcementId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Announcement selectAnnouncementById(Integer announcementId)
    {
        return announcementMapper.selectAnnouncementById(announcementId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param announcement 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Announcement> selectAnnouncementList(Announcement announcement)
    {
        return announcementMapper.selectAnnouncementList(announcement);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param announcement 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAnnouncement(Announcement announcement)
    {
        return announcementMapper.insertAnnouncement(announcement);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param announcement 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAnnouncement(Announcement announcement)
    {
        return announcementMapper.updateAnnouncement(announcement);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param announcementIds 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAnnouncementByIds(Integer[] announcementIds)
    {
        return announcementMapper.deleteAnnouncementByIds(announcementIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param announcementId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAnnouncementById(Integer announcementId)
    {
        return announcementMapper.deleteAnnouncementById(announcementId);
    }
}
