package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AddressMapper;
import com.ruoyi.system.domain.Address;
import com.ruoyi.system.service.IAddressService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
@Service
public class AddressServiceImpl implements IAddressService 
{
    @Autowired
    private AddressMapper addressMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param addressId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Address selectAddressById(Integer addressId)
    {
        return addressMapper.selectAddressById(addressId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param address 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Address> selectAddressList(Address address)
    {
        return addressMapper.selectAddressList(address);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param address 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAddress(Address address)
    {
        return addressMapper.insertAddress(address);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param address 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAddress(Address address)
    {
        return addressMapper.updateAddress(address);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param addressIds 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAddressByIds(Integer[] addressIds)
    {
        return addressMapper.deleteAddressByIds(addressIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param addressId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteAddressById(Integer addressId)
    {
        return addressMapper.deleteAddressById(addressId);
    }
}
