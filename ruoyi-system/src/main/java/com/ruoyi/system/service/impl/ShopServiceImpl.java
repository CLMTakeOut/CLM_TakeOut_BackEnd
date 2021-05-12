package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ShopMapper;
import com.ruoyi.system.domain.Shop;
import com.ruoyi.system.service.IShopService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
@Service
public class ShopServiceImpl implements IShopService 
{
    @Autowired
    private ShopMapper shopMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param shopId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Shop selectShopById(Integer shopId)
    {
        return shopMapper.selectShopById(shopId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param shop 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Shop> selectShopList(Shop shop)
    {
        return shopMapper.selectShopList(shop);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param shop 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertShop(Shop shop)
    {
        return shopMapper.insertShop(shop);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param shop 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateShop(Shop shop)
    {
        return shopMapper.updateShop(shop);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param shopIds 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteShopByIds(Integer[] shopIds)
    {
        return shopMapper.deleteShopByIds(shopIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param shopId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteShopById(Integer shopId)
    {
        return shopMapper.deleteShopById(shopId);
    }
}
