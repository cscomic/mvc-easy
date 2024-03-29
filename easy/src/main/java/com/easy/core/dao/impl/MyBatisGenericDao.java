/**
 * Copyright (c) 2012-2013 All Rights Reserved.
 */
package com.easy.core.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * mybatis基础操作Dao
 * 
 * @author wy
 * @version v 0.1 2013-3-5 下午10:45:16 wy Exp $
 */
public abstract class MyBatisGenericDao extends SqlSessionDaoSupport {
    /**
     * 查询出一个对象
     * 
     * @param statement
     * @param object
     * @return
     */
    @SuppressWarnings("unchecked")
    protected final <T> T get(String statement, Object object) {
        if (object == null) {
            return (T) getSqlSession().selectOne(statement);
        }
        return (T) getSqlSession().selectOne(statement, object);
    }

    /**
     * 查询出列表
     * 
     * @param statement
     * @param param
     * @return
     */
    @SuppressWarnings("unchecked")
    protected final <T> List<T> list(String statement, Object object) {
        if (object == null) {
            return list(statement);
        }
        return (List<T>) getSqlSession().selectList(statement, object);
    }

    /**
     * 查询出列表
     * 
     * @param statement
     * @param param
     * @return
     */
    @SuppressWarnings("unchecked")
    protected final <T> List<T> list(String statement) {
        return (List<T>) getSqlSession().selectList(statement);
    }

    /**
     * 分页查询
     * 
     * @param statement
     * @param rowBounds
     * @return
     */
    protected final <T> List<T> list(String statement, RowBounds rowBounds) {
        return list(statement, null, rowBounds);
    }

    /**
     * 分页查询
     * 
     * @param statement
     * @param object
     * @param rowBounds
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> list(String statement, Object object, RowBounds rowBounds) {
        return (List<T>) getSqlSession().selectList(statement, object, rowBounds);
    }

    /**
     * 插入记录
     * 
     * @param statement
     * @param object
     * @return
     */
    public int save(String statement, Object object) {
        if (object == null) {
            return getSqlSession().insert(statement);
        }
        return getSqlSession().insert(statement, object);

    }

    /**
     * 更新记录
     * 
     * @param statement
     * @param object
     * @return
     */
    protected final int update(String statement, Object object) {
        if (object == null) {
            return getSqlSession().update(statement);
        }
        return getSqlSession().update(statement, object);
    }

    /**
     * 删除记录
     * 
     * @param statement
     * @param object
     * @return
     */
    protected final int delete(String statement, Object object) {
        if (object == null) {
            return getSqlSession().delete(statement);
        }
        return getSqlSession().delete(statement, object);
    }

}
