package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Address;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public interface IAddressService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param addressId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Address selectAddressById(Integer addressId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param address 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Address> selectAddressList(Address address);

    /**
     * 新增【请填写功能名称】
     * 
     * @param address 【请填写功能名称】
     * @return 结果
     */
    public int insertAddress(Address address);

    /**
     * 修改【请填写功能名称】
     * 
     * @param address 【请填写功能名称】
     * @return 结果
     */
    public int updateAddress(Address address);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param addressIds 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAddressByIds(Integer[] addressIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param addressId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteAddressById(Integer addressId);

    // 修改当前地址
    public int updateAddressUsing(Integer customerId,Integer addressId);
}
