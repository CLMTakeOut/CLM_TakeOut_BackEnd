package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Shop;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public interface ShopMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param shopId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Shop selectShopById(Integer shopId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param shop 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Shop> selectShopList(Shop shop);

    /**
     * 新增【请填写功能名称】
     * 
     * @param shop 【请填写功能名称】
     * @return 结果
     */
    public int insertShop(Shop shop);

    /**
     * 修改【请填写功能名称】
     * 
     * @param shop 【请填写功能名称】
     * @return 结果
     */
    public int updateShop(Shop shop);

    /**
     * 删除【请填写功能名称】
     * 
     * @param shopId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteShopById(Integer shopId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param shopIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShopByIds(Integer[] shopIds);
}
