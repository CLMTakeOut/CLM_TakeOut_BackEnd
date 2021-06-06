package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GoodsMapper;
import com.ruoyi.system.domain.Goods;
import com.ruoyi.system.service.IGoodsService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
@Service
public class GoodsServiceImpl implements IGoodsService 
{
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param goodsId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Goods selectGoodsById(Integer goodsId)
    {
        return goodsMapper.selectGoodsById(goodsId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param goods 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Goods> selectGoodsList(Goods goods)
    {
        return goodsMapper.selectGoodsList(goods);
    }
    public List<Goods> getConsider(){
        return goodsMapper.getConsider();
    }
    /**
     * 新增【请填写功能名称】
     * 
     * @param goods 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertGoods(Goods goods)
    {
        return goodsMapper.insertGoods(goods);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param goods 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateGoods(Goods goods)
    {
        return goodsMapper.updateGoods(goods);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param goodsIds 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteGoodsByIds(Integer[] goodsIds)
    {
        return goodsMapper.deleteGoodsByIds(goodsIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param goodsId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteGoodsById(Integer goodsId)
    {
        return goodsMapper.deleteGoodsById(goodsId);
    }
}
