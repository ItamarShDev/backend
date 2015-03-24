package com.beike.dao;

import com.beike.base.AbstractDAO;
import com.beike.base.IEntityManagerHelper;
import com.beike.base.entitymanager.NoCacheEntityManagerHelper;

/**
 * Created by CJL on 2015/3/24.
 */
public class PictureDAO extends AbstractDAO<Picture> {

    @Override
    public Class getEntityClass() {
        return Picture.class;
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
