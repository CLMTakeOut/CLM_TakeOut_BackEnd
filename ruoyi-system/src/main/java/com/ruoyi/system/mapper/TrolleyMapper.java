package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Trolley;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-05
 */
public interface TrolleyMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param trolleyId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Trolley selectTrolleyById(Long trolleyId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param trolley 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Trolley> selectTrolleyList(Trolley trolley);

    /**
     * 新增【请填写功能名称】
     * 
     * @param trolley 【请填写功能名称】
     * @return 结果
     */
    public int insertTrolley(Trolley trolley);

    /**
     * 修改【请填写功能名称】
     * 
     * @param trolley 【请填写功能名称】
     * @return 结果
     */
    public int updateTrolley(Trolley trolley);

    /**
     * 删除【请填写功能名称】
     * 
     * @param trolleyId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTrolleyById(Long trolleyId);

    public int deleteTrolleyByCustomerId(Long customerId);
    /**
     * 批量删除【请填写功能名称】
     * 
     * @param trolleyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTrolleyByIds(Long[] trolleyIds);
}
