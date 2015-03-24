package com.beike.dao;

import com.beike.base.AbstractDAO;
import com.beike.base.IEntityManagerHelper;
import com.beike.base.entitymanager.NoCacheEntityManagerHelper;

/**
 * Created by huahui.yang on 3/22/15.
 */
public class UserDAO extends AbstractDAO<User> {

    @Override
    public Class getEntityClass() {
        return User.class;
    }

    @Override
    public IEntityManagerHelper getEntityManagerHelper() {
        return new NoCacheEntityManagerHelper();
    }

    @Override
    public String getPUName() {
        return "VMC_PU";
    }
}