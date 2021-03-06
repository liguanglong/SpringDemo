package com.example.dao.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiGuanglong
 * @date 2018/6/7
 */
public abstract class BaseCRUDDaoImpl<Entity> extends BaseDaoImpl implements CommonCRUDDao<Entity>
{
    private Class<Entity> entityClass = null;

    @SuppressWarnings("unchecked")
    public BaseCRUDDaoImpl()
    {
        this.entityClass = null;
        Class<?> c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType)
        {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<Entity>) parameterizedType[0];
        }
    }

    @Override
    public boolean deleteEntity(Entity entity)
    {
        int result = this.getSqlSession().delete(this.getEntityClass().getSimpleName() + ".deleteEntity", entity);
        return result == 1;
    }

    @Override
    public List<Entity> deleteEntityList(List<Entity> entityList)
    {
        List<Entity> result = new ArrayList<Entity>();
        for (Entity entity : entityList)
        {
            int operationResult = this.getSqlSession().delete(this.getEntityClass().getSimpleName() + ".deleteEntity", entity);
            if (operationResult == 1)
            {
                result.add(entity);
            }
        }
        return result;
    }

    @Override
    public Entity addEntity(Entity entity)
    {
        this.getSqlSession().insert(this.getEntityClass().getSimpleName() + ".addEntity", entity);
        return entity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Entity findEntityById(Entity entity)
    {
        return  (Entity)this.getSqlSession().selectOne(this.getEntityClass().getSimpleName() + ".findEntityById", entity);
    }


    @Override
    public boolean updateEntity(Entity entity)
    {
        int result = this.getSqlSession().update(this.getEntityClass().getSimpleName() + ".updateEntity", entity);
        return result == 1;
    }

    @Override
    public List<Entity> updateEntityList(List<Entity> entityList)
    {
        List<Entity> result = new ArrayList<Entity>();
        for (Entity entity : entityList)
        {
            int operationResult = this.getSqlSession().update(this.getEntityClass().getSimpleName() + ".updateEntity", entity);
            if (operationResult == 1)
            {
                result.add(entity);
            }
        }
        return result;
    }

    public Class<Entity> getEntityClass()
    {
        return entityClass;
    }
}
