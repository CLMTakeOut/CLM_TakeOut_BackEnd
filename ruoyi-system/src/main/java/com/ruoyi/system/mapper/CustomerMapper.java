package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Customer;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public interface CustomerMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param customerId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Customer selectCustomerById(Integer customerId);

    // 根据手机号查找用户id
    public Integer findCustomerByTel(String tel);

    // 根据手机号和密码查找
    public Customer findCustomerByTelAndPwd(@Param("tel")String tel, @Param("pwd") String pwd);
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
     * 删除【请填写功能名称】
     * 
     * @param customerId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCustomerById(Integer customerId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCustomerByIds(Integer[] customerIds);
}
