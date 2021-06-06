package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Order;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public interface IOrderService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param orderId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Order selectOrderById(Long orderId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param order 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Order> selectOrderList(Order order);

    /**
     * 修改【请填写功能名称】
     * 
     * @param order 【请填写功能名称】
     * @return 结果
     */
    public int updateOrder(Order order);
    public int insertOrder(Order order);
    /**
     * 批量删除【请填写功能名称】
     * 
     * @param orderIds 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteOrderByIds(Long[] orderIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param orderId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteOrderById(Long orderId);
}
