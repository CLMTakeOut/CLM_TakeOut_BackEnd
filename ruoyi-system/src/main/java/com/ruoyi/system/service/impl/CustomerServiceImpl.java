package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CustomerMapper;
import com.ruoyi.system.domain.Customer;
import com.ruoyi.system.service.ICustomerService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
@Service
public class CustomerServiceImpl implements ICustomerService 
{
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param customerId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Customer selectCustomerById(Integer customerId)
    {
        return customerMapper.selectCustomerById(customerId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param customer 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Customer> selectCustomerList(Customer customer)
    {
        return customerMapper.selectCustomerList(customer);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param customer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCustomer(Customer customer)
    {
        return customerMapper.insertCustomer(customer);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param customer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCustomer(Customer customer)
    {
        return customerMapper.updateCustomer(customer);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param customerIds 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCustomerByIds(Integer[] customerIds)
    {
        return customerMapper.deleteCustomerByIds(customerIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param customerId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCustomerById(Integer customerId)
    {
        return customerMapper.deleteCustomerById(customerId);
    }
}
