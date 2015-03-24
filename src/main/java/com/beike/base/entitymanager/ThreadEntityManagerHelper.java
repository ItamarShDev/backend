package com.beike.base.entitymanager;

import javax.persistence.EntityManager;
import com.beike.base.IEntityManagerHelper;
import java.util.Map;
import java.util.HashMap;

/**
 * 保持线程池的JPA数据库管理器
 * 是用来解决长链接问题的实现
 * (这个是会有缓存的！)
 */
public class ThreadEntityManagerHelper implements IEntityManagerHelper {

    private static final Map<String, ThreadLocal<EntityManager>> threadLocalMap =
            new HashMap<String, ThreadLocal<EntityManager>>();

    public EntityManager getEntityManager(String PUName) {

        if (!threadLocalMap.containsKey(PUName)) {
            threadLocalMap.put(PUName, new ThreadLocal<EntityManager>());
        }

        EntityManager manager = threadLocalMap.get(PUName).get();

        if (manager == null || !manager.isOpen()) {
            manager = new SimpleEntityManagerHelper().getEntityManager(PUName);
            threadLocalMap.get(PUName).set(manager);
        }
        return manager;
    }
}