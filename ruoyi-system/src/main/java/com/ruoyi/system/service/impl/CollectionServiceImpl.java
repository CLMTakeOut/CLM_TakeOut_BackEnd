package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CollectionMapper;
import com.ruoyi.system.domain.Favorite;
import com.ruoyi.system.service.ICollectionService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
@Service
public class CollectionServiceImpl implements ICollectionService 
{
    @Autowired
    private CollectionMapper collectionMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param collectionId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Favorite selectCollectionById(Integer collectionId)
    {
        return collectionMapper.selectCollectionById(collectionId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param collection 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Favorite> selectCollectionList(Favorite collection)
    {
        return collectionMapper.selectCollectionList(collection);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param collection 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertCollection(Favorite collection)
    {
        return collectionMapper.insertCollection(collection);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param collection 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCollection(Favorite collection)
    {
        return collectionMapper.updateCollection(collection);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param collectionIds 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCollectionByIds(Integer[] collectionIds)
    {
        return collectionMapper.deleteCollectionByIds(collectionIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param collectionId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCollectionById(Integer collectionId)
    {
        return collectionMapper.deleteCollectionById(collectionId);
    }
}
