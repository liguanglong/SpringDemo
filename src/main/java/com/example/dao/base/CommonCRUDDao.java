package com.example.dao.base;

import java.util.List;

/**
 * @author LiGuanglong
 * @date 2018/6/7
 */
public interface CommonCRUDDao<Entity>
{
    /**
     * insert
     * @param
     * @return 返回实体包含生成主键
     */
    public Entity addEntity(Entity entity);

    /**
     * delete
     * @param entity
     * @return 是否删除成功
     */
    public boolean deleteEntity(Entity entity);

    /**
     * update
     * @param entity
     * @return 是否更新成功
     */
    public boolean updateEntity(Entity entity);

    /**
     * delete list
     * @param entityList
     * @return 返回删除成功实体列表
     */
    public List<Entity> deleteEntityList(List<Entity> entityList);

    /**
     * update list
     * @param entityList
     * @return 返回更新成功实体列表
     */
    public List<Entity> updateEntityList(List<Entity> entityList);


    /**
     * select by id
     * @param
     * @return 实体
     */
    public Entity findEntityById(Entity entity);
}