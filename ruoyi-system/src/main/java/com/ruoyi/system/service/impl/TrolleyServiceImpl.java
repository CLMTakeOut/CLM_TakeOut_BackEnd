package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TrolleyMapper;
import com.ruoyi.system.domain.Trolley;
import com.ruoyi.system.service.ITrolleyService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-05
 */
@Service
public class TrolleyServiceImpl implements ITrolleyService 
{
    private TrolleyMapper trolleyMapper;
    @Autowired
    public void setTrolleyMapper(TrolleyMapper trolleyMapper) {
        this.trolleyMapper = trolleyMapper;
    }

    /**
     * 查询【请填写功能名称】
     * 
     * @param trolleyId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Trolley selectTrolleyById(Long trolleyId)
    {
        return trolleyMapper.selectTrolleyById(trolleyId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param trolley 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Trolley> selectTrolleyList(Trolley trolley)
    {
        return trolleyMapper.selectTrolleyList(trolley);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param trolley 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTrolley(Trolley trolley)
    {
        return trolleyMapper.insertTrolley(trolley);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param trolley 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTrolley(Trolley trolley)
    {
        return trolleyMapper.updateTrolley(trolley);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param trolleyIds 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteTrolleyByIds(Long[] trolleyIds)
    {
        return trolleyMapper.deleteTrolleyByIds(trolleyIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param trolleyId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteTrolleyById(Long trolleyId)
    {
        return trolleyMapper.deleteTrolleyById(trolleyId);
    }

    public int deleteTrolleyByCustomerId(Long customerId){
        return trolleyMapper.deleteTrolleyByCustomerId(customerId);
    }
}
