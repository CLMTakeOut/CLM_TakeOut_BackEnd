package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Goods;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public interface GoodsMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param goodsId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Goods selectGoodsById(Integer goodsId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param goods 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Goods> selectGoodsList(Goods goods);

    /**
     * 新增【请填写功能名称】
     * 
     * @param goods 【请填写功能名称】
     * @return 结果
     */
    public int insertGoods(Goods goods);

    /**
     * 修改【请填写功能名称】
     * 
     * @param goods 【请填写功能名称】
     * @return 结果
     */
    public int updateGoods(Goods goods);
    /**
     * 删除【请填写功能名称】
     * 
     * @param goodsId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteGoodsById(Integer goodsId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param goodsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteGoodsByIds(Integer[] goodsIds);
}
