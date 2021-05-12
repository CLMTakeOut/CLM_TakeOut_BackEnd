package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Favorite;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-12
 */
public interface CollectionMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param collectionId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Favorite selectCollectionById(Integer collectionId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param collection 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Favorite> selectCollectionList(Favorite collection);

    /**
     * 新增【请填写功能名称】
     * 
     * @param collection 【请填写功能名称】
     * @return 结果
     */
    public int insertCollection(Favorite collection);

    /**
     * 修改【请填写功能名称】
     * 
     * @param collection 【请填写功能名称】
     * @return 结果
     */
    public int updateCollection(Favorite collection);

    /**
     * 删除【请填写功能名称】
     * 
     * @param collectionId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCollectionById(Integer collectionId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param collectionIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCollectionByIds(Integer[] collectionIds);
}
