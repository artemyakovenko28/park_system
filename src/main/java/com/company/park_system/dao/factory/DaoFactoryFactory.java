package com.company.park_system.dao.factory;

public class DaoFactoryFactory {
    //todo: realize with getting information from application context
    public static DaoFactory createDaoFactory() {
        return new DaoFactoryJdbcImpl();
    }
}
