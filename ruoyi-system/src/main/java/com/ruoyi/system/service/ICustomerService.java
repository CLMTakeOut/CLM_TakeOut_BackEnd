package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Customer;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public interface ICustomerService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param customerId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Customer selectCustomerById(Integer customerId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param customer 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Customer> selectCustomerList(Customer customer);

    /**
     * 新增【请填写功能名称】
     * 
     * @param customer 【请填写功能名称】
     * @return 结果
     */
    public int insertCustomer(Customer customer);

    /**
     * 修改【请填写功能名称】
     * 
     * @param customer 【请填写功能名称】
     * @return 结果
     */
    public int updateCustomer(Customer customer);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param customerIds 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCustomerByIds(Integer[] customerIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param customerId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCustomerById(Integer customerId);
}
