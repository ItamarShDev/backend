package com.beike.base;

/**
* Created by huahui.yang on 3/22/15.
*/
import javax.persistence.EntityManager;

public interface IEntityManagerHelper {
    /**
     * 获取JPA数据库连接
     * @param PUName 数据库单元的名称
     * @return
     */
    public EntityManager getEntityManager(String PUName);
}
